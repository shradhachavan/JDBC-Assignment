package globant.jdbcassignment.week4;
import java.io.*;
import java.sql.*;
public class RetriveImage {
	public static void main(String args[]) throws ClassNotFoundException, SQLException, IOException{
	Class.forName("com.mysql.jdbc.Driver");
	String url = "jdbc:mysql://localhost:3306/image";
	String username = "root";
	String password = "root";
	Connection con=DriverManager.getConnection(url,username,password);
	File file=new File("E:\\Java_Globant\\image\\image1.png");
	FileOutputStream fos=new FileOutputStream(file);
	byte b[];
	Blob blob;
	PreparedStatement ps=con.prepareStatement("select * from Image_Table");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
	blob=rs.getBlob("image");
	b=blob.getBytes(1,(int)blob.length());
	fos.write(b);
	}
	System.out.println("Image retrive sucessfully");
	ps.close();
	fos.close();
	con.close();
	}
	}
	

