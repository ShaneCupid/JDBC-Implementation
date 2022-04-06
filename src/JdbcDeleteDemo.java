import java.sql.*;
public class JdbcDeleteDemo {


	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		String dbUrl = "jdbc:mysql://localhost:3306/demo";
		String user = "student";
		String pass = "student";

		try {
			//work with this path instead of recommended path from video
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root", "HendrixDavid#77");
			//get a connection to a database
			//myConn = DriverManager.getConnection(dbUrl, user, pass);
			
			//create a statement
			myStmt = myConn.createStatement();
			
			//call helper method to display the employees information
			System.out.println("Before the delete...");
			displayEmployee(myConn, "John", "Doe");
			
			//delete the employee
			System.out.println("\nDeleting the employee: John Doe\n");
			
		
			int rowsAffected = myStmt.executeUpdate( 
					"delete from employee " +
			"where last_name='Doe' and first_name='John'");
			
			//call helper method to display the employees information
			System.out.println("After the delete...");
			displayEmployee(myConn, "John", "Doe");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			close(myConn, myStmt, myRs);		
			}
		}

	private static void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		// TODO Auto-generated method stub
		
	}

	private static void displayEmployee(Connection myConn, String string, String string2) {
		// TODO Auto-generated method stub
		
	}} 
