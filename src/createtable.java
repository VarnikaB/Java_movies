import java.sql.*;

public class createtable{

   public static void main( String args[] ) {
      Connection c = null;
      Statement stmt = null;
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl2","scott","tiger");

         stmt = c.createStatement();
         String sql = "CREATE TABLE Movies " +
                        "(ID  INT Unique     NOT NULL," +
                        " Movie           varchar(50)    NOT NULL, " +
                        " LeadActor           varchar(50)     NOT NULL, " + 
                        " Actress           varchar(50)     NOT NULL, " + 
                        " Director        varchar(50) , "+
                        " Year           INT     NOT NULL) " ; 
         stmt.executeUpdate(sql);
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
   }
}