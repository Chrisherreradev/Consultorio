package config;
import java.sql.*;

public class conexion {
		
	public static Connection conectar() {
	
		try {
			Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_cm", "root","");
			return cn;
		} catch (SQLException e) {
			System.out.println("Error de conexion!" + e);
		}
		return (null);
	}
}
