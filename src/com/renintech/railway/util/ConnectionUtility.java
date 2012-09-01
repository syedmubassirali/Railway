package com.renintech.railway.util;
import java.sql.*;
public class ConnectionUtility {
          public static Connection getConnection()
          {
        	  
           Connection con=null;
           try
           {
        	   Class.forName("oracle.jdbc.driver.OracleDriver");
        	   con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","railwayinquiry12i","automation");
         
           }
        	catch(Exception e)
        	{
             System.out.println("Exception:"+e);
        	}
        	return con;
           }
        void  closeConnection(Connection con,PreparedStatement stmt,ResultSet rs)
          {
        	  try
  			{   if(rs!=null)
  				rs.close();
  				if(stmt!=null)
  					stmt.close();
  				if(con!=null)
  					con.close();
  			}
  			catch(Exception e)
  			{
  				System.out.println("exception:"+e);
  			}
          }
}
           
