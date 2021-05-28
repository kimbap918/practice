package mini02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
	public static Connection MemberDAOdb() {
		Connection con = null;
		try {
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String url = "jdbc:mysql://choicho.mysql.database.azure.com:3306/?autoReconnect=true&amp;serverTimezone=UTC";
		     String username = "choi_admin@choicho";
		     String password = "jun901800!";
			
			 con = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
