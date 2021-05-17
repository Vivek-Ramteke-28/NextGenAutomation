package nexgen.automation.framework.util;

import org.apache.log4j.Logger;

import java.sql.*;


public class DatabaseUtil {

	private static final Logger log = Logger.getLogger(DatabaseUtil.class);

	public static Connection getConnection(String host, String username, String password, String driverClass)
			throws SQLException, ClassNotFoundException {
		Class.forName(driverClass);
		return DriverManager.getConnection(host, username, password);
	}

	public static void executeWithNoResultSetUpdate(String host, String username, String password, String driverClass,
			String query) {

		try (Connection connection = getConnection(host, username, password, driverClass);
				Statement stmt = connection.createStatement();) {

			stmt.executeUpdate(query);

		} catch (ClassNotFoundException | SQLException e) {
			log.error(e.getMessage());
		}

	}

	public static void executeWithResultSet(String host, String username, String password, String driverClass,
			String query) {
		try (Connection connection = getConnection(host, username, password, driverClass);
				Statement stmt = connection.createStatement();) {

			stmt.executeQuery(query);

		} catch (ClassNotFoundException | SQLException e) {
			log.error(e.getMessage());
		} 

	}

	@SuppressWarnings("unused")
	private static void closeResource(AutoCloseable resource) {
		if (resource != null) {
			try {
				resource.close();
			} catch (Exception e) {
				log.error(e.getMessage());
			}
		}

	}

	/*
	 * public static void dbConnection(String host, String Username, String
	 * Password, String Driver, String query) {
	 * 
	 * Connection con = null;
	 * 
	 * try { Class.forName(Driver);
	 * 
	 * con = DriverManager.getConnection(host, Username, Password);
	 * 
	 * Statement stmt = con.createStatement();
	 * 
	 * ResultSet rs = stmt.executeQuery(query); } catch (ClassNotFoundException |
	 * SQLException e) { e.printStackTrace(); } finally { closeResource(con); }
	 * 
	 * }
	 */

}