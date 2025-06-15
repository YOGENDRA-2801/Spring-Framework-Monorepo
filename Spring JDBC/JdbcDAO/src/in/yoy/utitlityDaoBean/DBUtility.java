package in.yoy.utitlityDaoBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtility {
	private static final String driverName = "com.mysql.cj.jdbc.Driver";
	private static final String dbUrl = "jdbc:mysql://127.0.0.1:3306/spr_jdbc?" + "allowPublicKeyRetrieval=true&"
			+ "useSSL=false";
	private static final String username = "root";
	private static final String password = "ABCxyz123@";

	static {
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(dbUrl, username, password);
	}
}
