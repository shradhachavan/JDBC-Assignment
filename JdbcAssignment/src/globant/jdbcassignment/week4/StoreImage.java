package globant.jdbcassignment.week4;
import java.sql.*;
import java.io.*;
public class StoreImage {
	public static void main(String args[]) throws SQLException, ClassNotFoundException, IOException{
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/image";
	String username = "root";
	String password = "root";
	Connection con=DriverManager.getConnection(url,username,password);
	File file=new File("E:\\Java_Globant\\image\\image.png");
	FileInputStream fin=new FileInputStream(file);
	String query="insert into Image_Table (name,image) values(?,?)";
	PreparedStatement ps=con.prepareStatement(query);
	ps.setString(1,"image ");
	ps.setBinaryStream(2,fin,(int)file.length());
	ps.executeUpdate();
	ps.close();
	fin.close();
	System.out.println("Image inserted succesfully");
	con.close();
	}
	}


