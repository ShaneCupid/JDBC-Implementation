import java.sql.*;

public class Driver {
	public static void main(String[] args) throws SQLException {

		Connection myConn = null;
		PreparedStatement myStmt = null;
		ResultSet myRs = null;
		
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root", "HendrixDavid#77");

			myStmt = myConn.prepareStatement("select * from employees where salary > ? and department=?");
			
			//set parameters
			myStmt.setDouble(1, 80000);
			myStmt.setString(2, "Legal");
			
			//execute SQL Query
			myRs = myStmt.executeQuery();
			
			display(myRs);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
		finally {
			System.out.println("executions completed");		
			}
		}
	private static void display(ResultSet myRs) {
		// TODO Auto-generated method stub
		
	}}
