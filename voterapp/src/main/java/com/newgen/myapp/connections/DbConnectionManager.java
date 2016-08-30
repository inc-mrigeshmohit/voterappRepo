package com.newgen.myapp.connections;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnectionManager {
	// defining driver name, mysql-jdbc driver in this case
	private String driverName = "com.mysql.jdbc.Driver";
	private Connection con = null;
	private ResultSet rs = null;
	private Statement stmt = null;
	private PreparedStatement ps = null;
	private CallableStatement call = null;

	// database url string with hostname and port on which db is running
	private String url = "jdbc:mysql://localhost:3306/";

	public Connection getConnection(String dbName, String username,
			String password) {
		// creating connection url
		String connectionUrl = url + dbName;

		try {
			// registers the specified driver class into memory
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// returns a connection objcet by selecting an appropriate driver
			// for specified connection URL
			con = DriverManager
					.getConnection(connectionUrl, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	// TODO:
	public Connection getPoolConnection(String appName, String poolName) {
		return con;
	}

	// TODO:
	public Connection getDierctConnection(String url, String user,
			String password) {
		return con;
	}

	// //TODO:
	public Connection getDirectConnection(String url) {
		return con;
	}

	// TODO:
	public Connection reteyDirectConnection(String url, String userName,
			String password, int retryCount, int retryInterval) {
		return con;
	}

	// TODO:
	public Connection getDBDateTime() {
		return con;
	}

	public Statement createStatement() {
		// TODO Auto-generated method stub
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stmt;
	}

	public PreparedStatement preparedStatement(String sql) {
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ps;
	}

	public CallableStatement callableStatement(String sql) {
		try {
			call = con.prepareCall(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return call;
	}

	// TODO;
	public Connection closeConnection() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}

	// TODO:
	public ResultSet closeResultSet() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return rs;
	}

	public Statement closeStatement() {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return stmt;
	}

	// TODO:
	public PreparedStatement closePreparedStatement() {
		if (ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ps;
	}

	// TODO:
	public CallableStatement closeCallableStatemant() {
		if (call != null) {
			try {
				call.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return call;
	}
}
