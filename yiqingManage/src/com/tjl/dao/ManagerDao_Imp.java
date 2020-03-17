package com.tjl.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tjl.bean.Manager;
import com.tjl.bean.User;
import com.tjl.jdbc.JDBCUtils;
import com.tjl.view.View;

public class ManagerDao_Imp implements ManagerDao {

	private static final String SQL_Manager_LOGIN = "select type from manager where username=? and password=?";
	private static final String SQL_Manager_INSERT = "insert into user values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_Manager_DELETE = "delete from user where stuid=?";
	private static final String SQL_Manager_SELECTCOLLEGE = "select * from user where college = ?";
	private static final String SQL_Manager_SELECTCITY = "select * from USER where city = ?";
	private static final String SQL_Manager_SELECTIsReturn = "select * from USER where ISReturn=?";
	private static final String SQL_Manager_SELECTIsSuspect = "select * from USER where IsSuspect=?";

	@Override
//	管理员登录的实现
	public int login(Manager manager) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(SQL_Manager_LOGIN);
			pst.setString(1, manager.getUname());
			pst.setString(2, manager.getUpass());
			rs = pst.executeQuery();
			while (rs.next()) {
				int type = rs.getInt("type");
				return type;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con, pst, rs);
		}
		return -1;
	}

//  管理员添加用户信息
	@Override
	public boolean insert(User user) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(SQL_Manager_INSERT);
			pst.setString(1, user.getCollege());
			pst.setString(2, user.getGrade());
			pst.setString(3, user.getDate());
			pst.setString(4, user.getName());
			pst.setString(5, user.getStuid());
			pst.setString(6, user.getProvince());
			pst.setString(7, user.getCity());
			pst.setString(8, user.getRegion());
			pst.setString(9, user.getIsReturn());
			pst.setString(10, user.getIsSuspect());
			pst.setString(11, user.getIsInfect());
			int line = pst.executeUpdate();
			if (line > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con, pst, null);
		}
		return false;
	}

	@Override
//	管理员删除用户信息
	public boolean delete(String stuid) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = null;
		try {
			pst = con.prepareStatement(SQL_Manager_DELETE);
			pst.setString(1, stuid);
			int line = pst.executeUpdate();
			if (line > 0) {
				return true;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con, pst, null);
		}
		return false;
	}

//    查询菜单中根据学院进行查询的实现
	public User select(String college) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(SQL_Manager_SELECTCOLLEGE);
			pst.setString(1, college);
			rs = pst.executeQuery();
			System.out.println("学院  年级  上报日期  姓名  学号  是否今天从外地返校  是否有疑似症状  是否已经确诊");
			while (rs.next()) {
				college = rs.getString("college");
				String grade = rs.getString("grade");
				String date = rs.getString("date");
				String name = rs.getString("name");
				String stuid = rs.getString("stuid");
				String province = rs.getString("province");
				String city = rs.getString("city");
				String region = rs.getString("region");
				String IsReturn = rs.getString("IsReturn");
				String IsSuspect = rs.getString("IsSuspect");
				String IsInfect = rs.getString("IsInfect");
				System.out.println(college + "," + grade + "," + date + "," + name + "," + stuid + "," + province + ","
						+ city + "," + region + "," + IsReturn + "," + IsSuspect + "," + IsInfect);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con, pst, rs);
		}
		return null;
	}

	@Override
//	查询菜单中根据用户所在市进行查询的实现
	public User selectCity(String city) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(SQL_Manager_SELECTCITY);
			pst.setString(1, city);
			rs = pst.executeQuery();
			System.out.println("学院  年级  上报日期  姓名  学号  是否今天从外地返校  是否有疑似症状  是否已经确诊");
			while (rs.next()) {
				String college = rs.getString("college");
				String grade = rs.getString("grade");
				String date = rs.getString("date");
				String name = rs.getString("name");
				String stuid = rs.getString("stuid");
				String province = rs.getString("province");
				city = rs.getString("city");
				String region = rs.getString("region");
				String IsReturn = rs.getString("IsReturn");
				String IsSuspect = rs.getString("IsSuspect");
				String IsInfect = rs.getString("IsInfect");

				System.out.println(college + "," + grade + "," + date + "," + name + "," + stuid + "," + province + ","
						+ city + "," + region + "," + IsReturn + "," + IsSuspect + "," + IsInfect);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con, pst, rs);
		}
		return null;
	}

	@Override
//	查询菜单中根据用户是否返校查询的实现
	public User selectIsReturn(String IsReturn) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(SQL_Manager_SELECTIsReturn);
			pst.setString(1, IsReturn);
			rs = pst.executeQuery();
			System.out.println("学院  年级  上报日期  姓名  学号  是否今天从外地返校  是否有疑似症状  是否已经确诊");
			while (rs.next()) {
				String college = rs.getString("college");
				String grade = rs.getString("grade");
				String date = rs.getString("date");
				String name = rs.getString("name");
				String stuid = rs.getString("stuid");
				String province = rs.getString("province");
				String city = rs.getString("city");
				String region = rs.getString("region");
				IsReturn = rs.getString("IsReturn");
				String IsSuspect = rs.getString("IsSuspect");
				String IsInfect = rs.getString("IsInfect");

				System.out.println(college + "," + grade + "," + date + "," + name + "," + stuid + "," + province + ","
						+ city + "," + region + "," + IsReturn + "," + IsSuspect + "," + IsInfect);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con, pst, rs);
		}
		return null;
	}

	@Override
//	查询菜单中根据用户是否有疑似症状的查询的实现
	public User selectIsSuspect(String IsSuspect) {
		Connection con = JDBCUtils.getConnection();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			pst = con.prepareStatement(SQL_Manager_SELECTIsSuspect);
			pst.setString(1, IsSuspect);
			rs = pst.executeQuery();
			System.out.println("学院  年级  上报日期  姓名  学号  是否今天从外地返校  是否有疑似症状  是否已经确诊");
			while (rs.next()) {
				String college = rs.getString("college");
				String grade = rs.getString("grade");
				String date = rs.getString("date");
				String name = rs.getString("name");
				String stuid = rs.getString("stuid");
				String province = rs.getString("province");
				String city = rs.getString("city");
				String region = rs.getString("region");
				String IsReturn = rs.getString("IsReturn");
				IsSuspect = rs.getString("IsSuspect");
				String IsInfect = rs.getString("IsInfect");
				System.out.println(college + "," + grade + "," + date + "," + name + "," + stuid + "," + province + ","
						+ city + "," + region + "," + IsReturn + "," + IsSuspect + "," + IsInfect);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} finally {
			JDBCUtils.close(con, pst, rs);
		}
		return null;
	}
}