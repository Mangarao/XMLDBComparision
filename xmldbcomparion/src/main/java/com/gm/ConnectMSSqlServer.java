package com.gm;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectMSSqlServer {

	public List<Employee> getDBData() {
		List<Employee> dbEmpList = null;
		try {
			Connection conn = getDbConnection();
			PreparedStatement ps = conn.prepareStatement("select * from employee");
			ResultSet rs = ps.executeQuery();
			dbEmpList = new ArrayList();
			while(rs.next()){
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setFirstName(rs.getString(2));
				e.setLastName(rs.getString(3));
				e.setTitle(rs.getString(4));
				e.setSalary(rs.getFloat(5));
				e.setHireDate(rs.getString(6));
				dbEmpList.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		return dbEmpList;

	}

	private static Connection getDbConnection()
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		//1. Load driver class
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		//2. create connection object
		Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost\\mysqlserver", "sa",
				"amr@Deloitte1");

		return conn;
	}

}
