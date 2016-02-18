import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = null;
		Statement stmt = null;
		ResultSet  rset= null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
 
// THIS IS WHERE IT ALL DIES ON ME
    conn =  DriverManager
    		.getConnection("jdbc:mysql://localhost:3306/ormdb","root", "14789632");
 
			String query = "SELECT * from Producto";
 
			stmt = conn.createStatement();
			
			rset = stmt.executeQuery(query);
		}
		catch (SQLException se) {
			System.out.println("SQLError: " + se.getMessage() + " code: " + se.getErrorCode());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
