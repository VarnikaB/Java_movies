import java.sql.*;
import java.util.*;
public class query{
static Scanner sc = new Scanner(System.in);
  public static void main( String args[] ) {
	  
   Connection c = null;
   Statement stmt = null;
   try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
      c.setAutoCommit(false);
      int choice;
      do {
	      choice = menu();
	      
	      stmt = c.createStatement();
	      ResultSet rs;
	      if (choice == 1)
	    	  rs = stmt.executeQuery( "SELECT * FROM Movies" );
	      else if (choice == 2)
	      {   
	    	  System.out.print("Movie: ");
	    	  String name = sc.nextLine();
	    	  name = sc.nextLine();
	    	  
	    	  rs = stmt.executeQuery( "SELECT * FROM Movies where movie = '"+name+"'" );
	      }
	      else if (choice == 3)
	      {   
	    	  System.out.print("Lead Actor: ");
	    	  String name = sc.nextLine();
	    	  name = sc.nextLine();
	    	  rs = stmt.executeQuery( "SELECT * FROM Movies where leadactor = '"+name+"'" );
	      }
	      else if (choice == 4)
	      {   
	    	  System.out.print("Actress: ");
	    	  String name = sc.nextLine();
	    	  name = sc.nextLine();
	    	  
	    	  rs = stmt.executeQuery( "SELECT * FROM Movies where actress = '"+name+"'" );
	      }
	      else if (choice == 5)
	      {   
	    	  System.out.print("Director: ");
	    	  String name = sc.nextLine();
	    	  name = sc.nextLine();
	    	  
	    	  rs = stmt.executeQuery( "SELECT * FROM Movies where director = '"+name+"'" );
	      }
	      else
	    	  return;
	      
	      
	      while ( rs.next() ) {
	         int id = rs.getInt("id");
	         String  mname = rs.getString("movie");
	         String aname  = rs.getString("leadactor");
	         String  arname = rs.getString("actress");
	         String dname = rs.getString("director");
	         int year = rs.getInt("year");
	         
	         System.out.println( "ID = " + id );
	         System.out.println( "Movie Name = " + mname );
	         System.out.println( "Actor Name = " + aname );
	         System.out.println( "Actress Name = " + arname );
	         System.out.println( "Director Name = " + dname);
	         System.out.println( "Year = " + year );
	         System.out.println();
	      }
	      rs.close();
	      stmt.close();
      }while(choice != 6);
      
      c.close();
   } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      System.exit(0);
   }
   System.out.println("Operation done successfully");
  }

private static int menu() {
	// TODO Auto-generated method stub
	System.out.println("Enter choice: ");
	System.out.println("1. Entire table ");
	System.out.println("3. Movie name ");
	System.out.println("3. Movie with Actor name ");
	System.out.println("4. Movie with Actress name ");
	System.out.println("5. Movie with Director name");
	System.out.println("6. Exit");
	return sc.nextInt();
}
}