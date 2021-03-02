package paquete1;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Timestamp;
public class Probador {

	public static void main(String[] args) {
		java.util.Date date=getfecha(7894);	
		java.util.Date date1=getfecha(5555);
		System.out.println((date1.getTime()-date.getTime())/60000);
		
	}
	
	public static java.util.Date getfecha(int patente) {
		Conexion conexion=new Conexion();
		Connection con=conexion.conexion();
		java.util.Date date=null;
		try {
			Statement stm=con.createStatement();
			String sql="SELECT * FROM vehiculos WHERE placa='"+patente+"'";
			ResultSet rs=stm.executeQuery(sql);
			if(rs.next()) {
				date=new Date(rs.getTime(4).getTime());	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
		
	}
}
