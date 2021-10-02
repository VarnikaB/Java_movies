import java.sql.*;

public class insertinto{

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");
         c.setAutoCommit(false);

         stmt = c.createStatement();
         String sql = "INSERT INTO Movies (ID,movie,leadactor,Actress,Director,year) " +
                        "VALUES (1, 'The Batman', 'Robert Pattinson', 'Zoë Kravitz', 'Matt Reeves', 2022)"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Movies  (ID,movie,leadactor,Actress,Director,year)  " +
                  "VALUES (2, 'Raaz 3', 'Emraan Hashmi', 'Esha Gupta', 'Vikram Bhatt', 2012 )"; 
         stmt.executeUpdate(sql);
         sql = "INSERT INTO Movies (ID,movie,leadactor,Actress,Director,year)  " +
                  "VALUES (3, 'The Conjuring', 'Patrick Wilson', 'Vera Farmiga', 'James Wan', 2013 )"; 
         stmt.executeUpdate(sql);

         sql = "INSERT INTO Movies (ID,movie,leadactor,Actress,Director,year) " +
                  "VALUES (4, 'Dead Silence', 'Ryan Kwanten', 'Amber Valletta', 'James Wan', 2007 )"; 
         stmt.executeUpdate(sql);

         stmt.close();
         c.commit();
         c.close();
      } 
      catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
   }
}