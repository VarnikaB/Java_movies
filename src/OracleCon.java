import java.sql.*;  
class OracleCon
{  
	public static void main(String args[])
	{  
		try
		{  
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
			Statement stmt = con.createStatement();
			
		     	createtable ct = new createtable(); 
			ct.main(args);
			System.out.println("Table created successfully");
			insertinto ins  = new insertinto();
			ins.main(args);
			System.out.println("Values inserted successfully");
			query q = new query();
			q.main(args);
			con.close(); 		      
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  

	}  
}  
