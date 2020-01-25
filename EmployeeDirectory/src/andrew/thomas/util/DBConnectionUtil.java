package andrew.thomas.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionUtil {

	// static database fields
	public static final String USERNAME = "root";
	public static final String PASSWORD = "";
	public static final String JDBC_URL = "jdbc:mysql://localhost:3306/employeedirectory";
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static Connection connection = null;

	// connection method
	public static Connection openConnection() {

		if (connection != null) {
			return connection;
		} else {

			// load driver
			try {
				Class.forName(DRIVER);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			// get connection
			try {
				connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			} catch (SQLException e) {

				e.printStackTrace();
			}
			
			return connection;
		}

		
	}

}
