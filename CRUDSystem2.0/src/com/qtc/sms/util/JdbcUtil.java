package com.qtc.sms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/sms";
	public static final String USER = "root";
	public static final String PASSWORD = "zya20010922";

		static {
			// 加载驱动
			try {
				Class.forName(DRIVER_NAME);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}


		public static Connection getconn() {
			// 创建一个连接对象
			Connection conn = null;
			
			try {
				conn = DriverManager.getConnection(URL,USER,PASSWORD);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return conn;
			
		}
		// 表的增删改进行操作
		public static int executeUpdate(String sql, Object[] params) {
			int count = 0; 
			
			Connection conn = JdbcUtil.getconn();
			
			//准备SQL
			PreparedStatement ps = null;
			
			//insert into user(''''''','') value(?, ?, ?)
			try {
				//准备SQL
				ps = conn.prepareStatement(sql);
				
				for(int i=0; i<params.length; i++) {
					ps.setObject(i+1, params[i]);
				}
				
				count = ps.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				JdbcUtil.closeall(null, ps, conn);
				
			}
	
		return count;
}

		// 表的查询操作
		public static ResultSet executeQuery(String sql, Object[] params) {

			ResultSet rs =null;

			Connection conn = JdbcUtil.getconn();

			//准备SQL
			PreparedStatement ps = null;

			try {
				//准备SQL
				ps = conn.prepareStatement(sql);

				if (params != null) {
					for(int i=0; i<params.length; i++) {
						ps.setObject(i+1, params[i]);
					}
				}

				//count = ps.executeUpdate();
				rs = ps.executeQuery();

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		return rs;
}



		public static void closeall(ResultSet rs, PreparedStatement ps, Connection conn) {
			
			try {
				if(rs!=null) {
					rs.close();
				}
				if(ps!=null) {
					ps.close();
				}
				
				if(conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
