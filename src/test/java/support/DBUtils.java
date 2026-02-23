package support;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtils {
	private Connection conn;

	public void connect(String url, String user, String pass) throws SQLException {
		conn = DriverManager.getConnection(url, user, pass);
	}

	public ResultSet runQuery(String sql) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(sql);
	}

	public void close() throws SQLException {
		if (conn != null)
			conn.close();
	}

}
