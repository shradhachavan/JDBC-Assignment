package globant.jdbcassignment.week4;

import java.sql.*;

public class CurdOperation {
	Connection con;
	ResultSet rs;
	void opendb() throws Exception {
	String url = "jdbc:mysql://localhost:3306/collegemanagmentsystem";
	String username = "root";
	String password = "root";
	Class.forName("com.mysql.jdbc.Driver");
	 con=DriverManager.getConnection(url,username,password);
	}
	void create() throws Exception {
		opendb();
		String query="create table Student(Roll_no int(200)primary key,sname varchar(100),Address varchar(100),"
				+ "ContNo VARCHAR(15))";	 
		Statement st = con.createStatement();
	   st.execute(query);
	   System.out.println("Table is created sucfully");
	   st.close();
       con.close();
	}
	void insert() throws Exception {
		opendb();
		String query="INSERT INTO Student VALUES (1,'Roopa','Delhi',9154756322);";	 
		Statement st = con.createStatement();
	   st.execute(query);
	   System.out.println("Data inserted sucfully");
	   st.close();
       con.close();
	}
	void update() throws Exception {
		opendb();	 
		String query = "UPDATE Student SET sname='Shradha' WHERE Address='Delhi'";
		Statement st = con.createStatement();
	         st.executeUpdate(query);
	         String Query="select *from Student";
	         ResultSet rs = st.executeQuery(Query);
	         while(rs.next()){
	           
	            System.out.println("Roll_no: " + rs.getInt("Roll_no"));
	            System.out.println(" Student name: " + rs.getString("sname"));
	            System.out.println(" Address: " + rs.getString("Address"));
	            System.out.println("Contact no: " + rs.getString("ContNo"));
	         }
	         rs.close();
	         st.close();
	         con.close();
	 }

	void Delet() throws Exception {
		opendb();
		String query="DELETE FROM Student WHERE Roll_no=1";	 
		Statement st = con.createStatement();
	   st.execute(query);
	   System.out.println("Data Deleted succesfully");
	   con.close();
	}
	public static void main(String[] args) throws Exception {
		CurdOperation obj=new CurdOperation();
     	obj.create();
		obj.insert();
		obj.update();
		obj.Delet();
	}
}
