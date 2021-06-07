package globant.jdbcassignment.week4;

import java.sql.*;
import java.util.Scanner;

public class PrepadedStatment {
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
		String query="create table attendance(student_name varchar(100),count int(50),Percentage decimal(5,2),Roll_no int references student(Roll_no))";	 
		PreparedStatement st = con.prepareStatement(query);
	   st.execute(query);
	   System.out.println("Table is created sucfully");
	   st.close();
       con.close();
	}
	void insert(String student_name,int count,String Percentage,int Roll_no) throws Exception {
		opendb();
		String query="INSERT INTO attendance(student_name, count,Percentage,Roll_no) VALUES (?, ?, ?, ?)";	 
		PreparedStatement st = con.prepareStatement(query);
		st.setString(1, student_name);
		st.setInt(2, count);
		st.setString(3, Percentage);
		st.setInt(4, Roll_no);
		int rowsInserted = st.executeUpdate();
		if (rowsInserted > 0) {
		    System.out.println("Data inserted successfully!");
		}
		 st.close();
         con.close();
	}
	void update() throws Exception {
		opendb();	 
		String query = "UPDATE attendance SET snstudent_nameame='Shradha' WHERE Roll_no=2";
		PreparedStatement st = con.prepareStatement(query);
	         String Query="select *from attendance";
	         ResultSet rs = st.executeQuery(Query);
	         while(rs.next()){
	           
	            System.out.println("student_name: " + rs.getString("student_name"));
	            System.out.println(" count: " + rs.getInt("count"));
	            System.out.println(" Percentage: " + rs.getString("Percentage"));
	            System.out.println("Roll_no: " + rs.getInt("Roll_no"));
	         }
	         rs.close();
	         st.close();
	         con.close();
	 }

	void Delet(int Roll_no) throws Exception {
		opendb();
		String query = "DELETE FROM attendance WHERE Roll_no=?";
		PreparedStatement st = con.prepareStatement(query);
		st.setInt(1,Roll_no); 
		int rowsDeleted = st.executeUpdate();
		if (rowsDeleted > 0) {
		    System.out.println("A user was deleted successfully!");
		}
		st.close();
	   con.close();
	}
	public static void main(String[] args) throws Exception {
		Scanner sc=new Scanner(System.in);
		PrepadedStatment obj=new PrepadedStatment();
     	obj.create();
		System.out.println("Enter Student name");
		String student_name=sc.next();
		System.out.println("Enter count");
		int count=sc.nextInt();
		System.out.println("Enter Percentage");
		String Percentage=sc.next();
		System.out.println("Enter roll no");
		int Roll_no=sc.nextInt();
		obj.insert(student_name,count,Percentage ,Roll_no);
		obj.update();
		obj.Delet(Roll_no);
		

	}
}
