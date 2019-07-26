package Utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class jdbc extends commonOps{
	public static Connection con;
	public static Statement stat;
	public static ResultSet rs;

	public static void initJDBC() throws ClassNotFoundException, SQLException, ParserConfigurationException, SAXException, IOException
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(getData("DB_URL"),getData("DB_User"),getData("DB_Pass"));
		stat = con.createStatement();
	}
	public static void retrieveInfo(String query) throws SQLException 
	{
		rs = stat.executeQuery(query);
	}
	public static String parseData() throws SQLException
	{
		String value = null;
		while (rs.next()) {
			value = rs.getString("customer_id"); 
		}
		return value ;
	}
	public static void closeDBCon() throws SQLException
	{
		con.close();	
	}
}

