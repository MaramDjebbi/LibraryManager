package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connec {
	Connection con;

	public Connec(){
		try{
		Class.forName("com.mysql.jdbc.Driver");
			
		con=DriverManager.getConnection("jdbc:mysql://localhost/biblio","root","");
			
			System.out.println("connected!!");
	}
		catch(Exception e){
			System.out.println("connected not yet!!");
			
		}

}
	public Connection connecion(){
		return con;
	}
}