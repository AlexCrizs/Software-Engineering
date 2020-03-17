package com.tjl.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
	private static String driver;
	private static String url;
	private static String username;
	private static String password;
	// 静态语句块
	static {
		InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("db.properties");
//		创建Property类型的对象
		Properties p = new Properties();
//		加载流文件
		try {
			p.load(is);
			driver = p.getProperty("driver");
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
			// 加载Mysql驱动
			Class.forName(driver);
//			System.out.println("驱动加载成功");
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}

//	获得连接对象的方法
	public static Connection getConnection() {
		try {
//			System.out.println("数据库连接成功");
			return DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
		
			e.printStackTrace();
			System.out.println("数据库连接失败");
		}
		return null;
	}

//	释放资源的方法
	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
				rs = null;
			}
			if (st != null) {
				st.close();
				st = null;
			}
			if (con != null) {
				con.close();
				con = null;
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
