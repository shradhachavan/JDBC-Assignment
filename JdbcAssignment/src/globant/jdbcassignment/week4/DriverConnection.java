package globant.jdbcassignment.week4;
import java.sql.*;
public class DriverConnection {
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/collegemanagmentsystem";
		String username = "root";
		String password = "root";
		
		Connection con=DriverManager.getConnection(url,username,password);
		if (con != null) {
			System.out.println("Database Connected successfully");
		} else {
			System.out.println("Database Connection failed");
		}
		con.close();
	}

}
