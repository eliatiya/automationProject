package Extensions;

import static org.testng.Assert.fail;

import com.relevantcodes.extentreports.LogStatus;

import Utilities.jdbc;

public class mySQLQueries extends jdbc{
	public static String queries(String query) 
	{
		String value = null;
		try {
			initJDBC();
			retrieveInfo(query);
			value = parseData();
			closeDBCon();
			test.log(LogStatus.PASS,"Query Successfully created");
		}catch (Exception e) {
			test.log(LogStatus.FAIL,"Query to DB failed, see details:  " + e);
			fail("Query to DB failed, see details:  " + e);
		}
		return value ;
	}
}
