package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
	private final String serverName = "ADMIN\\PHILONG";
    private final String dbName = "congty";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "12345";
	
	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			
			String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
			
			conn = DriverManager.getConnection(url, userID, password);
			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());
				
				return conn;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} 
		return conn;
	}
	
	public static void main(String[] args) {
		try {
			System.out.println(new DBConnectSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
