package WorkFlows;

import Extensions.mySQLQueries;
import Utilities.jdbc;

public class db_query extends jdbc
{
  public static String getMessage (String customer_id,String value) 
  {
	  return mySQLQueries.queries("SELECT " +customer_id+ " FROM sakila.customer where first_name = '"+value+"' ;");
  }

}
