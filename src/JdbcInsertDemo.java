import java.sql.*;

public class JdbcInsertDemo {


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
			//execute SQL query

			//inserting new employee
			System.out.println("Inserting a new employee to database\n");
			int rowsAffected = myStmt.executeUpdate( 
					"insert into employees " +
							"(last_name, first_name, email, department, salary) " +
					"('Wright', 'Eric', 'ericwrigh@foo.com', 'HR', 33000.00)"); 

			myRs = myStmt.executeQuery("select * from employees order by last_name");
			//process the result set
			while(myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}	
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
		}}}
