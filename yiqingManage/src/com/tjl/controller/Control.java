package com.tjl.controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.tjl.bean.Manager;
import com.tjl.bean.User;
import com.tjl.dao.ManagerDao;
import com.tjl.dao.ManagerDao_Imp;
import com.tjl.jdbc.JDBCUtils;
import com.tjl.view.View;
import com.tjl.dao.Selectbar;

public class Control {

	public static void main(String[] args) throws SQLException {

//		给用户展示登录界面
		while (true) {
			Manager manager = View.indexView();
			ManagerDao_Imp managerDao_Imp = new ManagerDao_Imp();
			int type = managerDao_Imp.login(manager);
			switch (type) {
			case -1:
				System.out.println("输入有误，请重新输入");
				break;
			case 1:
				System.out.println("\n");
				
				managerServer();
				break;
			case 2:
				System.out.println("用户登录成功");
				break;
			default:
				break;
			}
		}

	}

	private static void managerServer() throws SQLException {
		ManagerDao_Imp managerDao_Imp = new ManagerDao_Imp();
		while (true) {
			int item = View.managerMenuView();
			boolean flag;
			switch (item) {
			case 1:
//				添加用户
				User user = View.addMenuView();
				flag = managerDao_Imp.insert(user);
				System.out.println(flag ? "添加成功" : "添加失败");
				break;
			case 2:
//				删除用户
				String stuid = View.deleteMenuView();
				flag = managerDao_Imp.delete(stuid);
				System.out.println(flag ? "删除成功" : "删除失败");
				break;
			case 3:
//				查询用户信息
				View.selectMenuView();
				int a1;
				do {
					a1 = View.selectMenuView();
					switch (a1) {
					case 3:
						System.out.println("已退出");
						System.exit(-1);
						break;
					case 1:
						String college = View.select();
						User selectedUser = managerDao_Imp.select(college);
						break;
					case 5:
						String city = View.selectCity();
						User selectedCity = managerDao_Imp.selectCity(city);
					case 2:
						String isReturn = View.selectIsReturn();
						User selectedIsReturn = managerDao_Imp.selectIsReturn(isReturn);
						break;
					case 4:
						String isSuspect = View.selectIsSuspect();
						User selectedIsSuspect = managerDao_Imp.selectIsSuspect(isSuspect);
						break;
					default:
						break;
					}
				} while (a1 != 5);
				break;
			case 4:
				//柱状图查看
				View.barMenuView();
				int b1;
				do {
					b1 = View.barMenuView();
					Selectbar bar = new Selectbar();
					switch (b1) {
					case 2:
						System.out.println("已退出");
						System.exit(-1);
						break;
					case 1:
						bar.Selectbar1();
						break;
					/*
					 * case 2: bar.selectbar2(); break;
					 */
					default:
						break;
					}
				} while (b1 != 3);
				break;
			case 5:
				System.out.println("已退出");
				System.exit(-1);
				break;
			default:
				break;
			}
		}

	}

}
