package connexion;

import java.sql.*;

public class ConnectionBdd {
	private static final String driver_name = "com.mysql.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost/aeroport";
	private static final String username = "root";
	private static final String password = "";
	
	// -----------------Autre methode ajouter une variable conn---------------------
	// private static Connection conn;
	/*
    public static Connection getConnection() {
        try {
            Class.forName(driver_name);
            try {
                conn = DriverManager.getConnection(url, username, password);
            } catch (SQLException ex) {
                // log an exception. fro example:
                System.out.println("Failed to create the database connection."); 
            }
        } catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        }
        return conn;
    }*/
	
	public static Connection getConnection() {
		try {
			Class.forName(driver_name);
			return DriverManager.getConnection(url, username, password);

		} catch(Exception e) {
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("unused")
	private static void close(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e){
				throw new RuntimeException(e);
			}
		}
	}
}
