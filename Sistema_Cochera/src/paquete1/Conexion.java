package paquete1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class Conexion {
	Connection con;
	String url="jdbc:mysql://remotemysql.com:3306/Ig2LNXGmWt?useSSL=false";
	String user="Ig2LNXGmWt";
	String password="POn48Bs6Gq";
	public Conexion() {		
	}
	
	public Connection conexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url, user, password);
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}
