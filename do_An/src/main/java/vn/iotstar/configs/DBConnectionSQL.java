package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnectionSQL {
	private final String serverName = "MSI";

	private final String dbName = "do_An_CNTT";

	private final String portNumber = "1433";

	private final String userID = "sa";

	private final String password = "123456789";

	public Connection getConnection() throws Exception {

		String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

		return DriverManager.getConnection(url, userID, password);

	}

	// Test chương trình. Kích phải chuột chọn run as->java application

	public static void main(String[] args) {

		try {
			System.out.println(new DBConnectionSQL().getConnection());

		} catch (Exception e) {

			e.printStackTrace();
		}

	}
}
