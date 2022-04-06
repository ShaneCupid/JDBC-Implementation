import java.sql.*;
public class JdbcUpdateDemo {


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
			System.out.println("Before the update...");
			displayEmployee(myConn, "John", "Doe");
			
			//update the employee
			System.out.println("\nExecuting the update for: John Doe\n");
			
		
			int rowsAffected = myStmt.executeUpdate( 
					"insert into employees " +
							"set email='john.doe@luv2code.com' " +
							"where last_name='Doe' and first_name='John'");
			
			//call helper method to display the employees information
			System.out.println("After the update...");
			displayEmployee(myConn, "John", "Doe");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
		}}

	private static void displayEmployee(Connection myConn, String string, String string2) {
		// TODO Auto-generated method stub
		
	}}
