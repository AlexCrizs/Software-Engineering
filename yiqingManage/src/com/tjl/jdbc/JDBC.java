package com.tjl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBC {

	public static void main(String[] args) {
		// 加载驱动
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
//			System.out.println("驱动加载成功");
			// 连接数据库
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/data", "root", "123456");
//			System.out.println("连接成功");
			Statement st = con.createStatement();
			// 执行sql语句，得到结果集
			ResultSet rs = st.executeQuery("select * from user");
			while (rs.next()) {
				System.out.print(rs.getString("college") + " ");
				System.out.print(rs.getString("grade") + " ");
				System.out.print(rs.getString("date") + " ");
				System.out.print(rs.getString("name") + " ");
				System.out.print(rs.getString("stuid") + " ");
				System.out.print(rs.getString("province") + " ");
				System.out.print(rs.getString("city") + " ");
				System.out.print(rs.getString("region") + " ");
				System.out.print(rs.getString("IsReturn") + " ");
				System.out.print(rs.getString("IsSuspect") + " ");
				System.out.println(rs.getString("IsInfect") + " ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("驱动加载失败");
			System.out.println("连接失败");
		}

	}

}
