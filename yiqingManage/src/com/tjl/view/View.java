package com.tjl.view;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.tjl.bean.Manager;
import com.tjl.bean.User;

public class View {

	private static Scanner input = new Scanner(System.in);

//	首页视图
	public static Manager indexView() {
		System.out.println("******************************************************");
		System.out.println("*                西北师范大学疫情上报系统                        *");
		System.out.println("*                      请输入账号                                     *");
		System.out.println("******************************************************");
		String username = input.nextLine();
		System.out.println("*                      请输入密码                                     *");
		String password = input.nextLine();
		System.out.println("******************************************************");
		return new Manager(username, password);
	}

//  管理员菜单视图
	public static int managerMenuView() {
		System.out.println("******************************************************");
		//System.out.println("*******\t欢迎进入系统\t\t\t*******");
		//System.out.println("********\t请根据提示进行操作\t\t\t********");
		//System.out.println("********\t0.退出\t\t\t\t********");
		System.out.println("                          添加疫情信息请输入 1                    |");
		System.out.println("                          删除疫情信息请输入 2                    |");
		System.out.println("                          查询疫情情况请输入 3                    |");
		System.out.println("                          查看疫情柱状图输入 4                    |");
		System.out.println("                          退出疫情系统请输入 5                    |");
		System.out.println("******************************************************");
		String type = input.nextLine();
		int item = Integer.parseInt(type);
		if (item < 0 || item > 5) {
			System.out.println("输入错误，请重新输入");
			return managerMenuView();
		}
		//System.out.println("********************************************************");
		return item;
	}

//  增加用户信息视图

	public static User addMenuView() {
		System.out.println("******************************************************");
		//System.out.println("********\t请根据提示进行操作\t\t\t********");
		System.out.println("                  请输入你的学院(简称)                  ");
		String college = input.nextLine();
		System.out.println("                  请输入你的班级                                           ");
		String grade = input.nextLine();
		System.out.println("                  请输入上报日期                                           ");
		String date = input.nextLine();
		System.out.println("                  请输入你的姓名                                           ");
		String name = input.nextLine();
		System.out.println("                  请输入你的学号");
		String stuid = input.nextLine();
		System.out.println("                  请输入所在省");
		String province = input.nextLine();
		System.out.println("                  请输入所在城");
		String city = input.nextLine();
		System.out.println("                  请输入所在区");
		String region = input.nextLine();
		System.out.println("                  请输入是否返校         ");
		String IsReturn = input.nextLine();
		System.out.println("                  请输入是否有疑似症状");
		String IsSuspect = input.nextLine();
		System.out.println("                  请输入是否确诊");
		String IsInfect = input.nextLine();
		System.out.println("******************************************************");
		return new User(college, grade, date, name, stuid, province, city, region, IsReturn, IsSuspect, IsInfect);
	}
//  删除学生信息视图

	public static String deleteMenuView() {
		//System.out.println("********************************************************");
		//System.out.println("********\t请根据提示进行操作\t\t\t********");
		System.out.println("                  请输入要删除学生的学号 ");
		String stuid = input.nextLine();
		System.out.println("********************************************************");
		return stuid;
	}

//  查询学生信息视图

	public static int selectMenuView() {
		//System.out.println("********************************************************");
		//System.out.println("********\t请根据提示进行操作\t\t\t********");
		System.out.println("                  按照学院进行查询请输入1");
		//System.out.println("                  按照所在地查询请输入2");
		System.out.println("                  按照是否有疑似症状查询请输入2");
		//System.out.println("                  按照是否返校查询请输入4");
		System.out.println("                  退出请输入3");
		String a = input.nextLine();
		int a1 = Integer.parseInt(a);
		if (a1 < 0 || a1 > 5) {
			System.out.println("输入错误，请重新输入");
			return selectMenuView();
		}
		System.out.println("********************************************************");
		return a1;
	}

//	根据学院查询
	public static String select() {
		//System.out.println("********************************************************");
		//System.out.println("********\t请根据提示进行操作\t\t\t********");
		System.out.println("                 请输入要查询的学院");
		String college = input.nextLine();
		System.out.println("********************************************************");
		return college;
	}

////	根据所在市查询
	public static String selectCity() {
		//System.out.println("********************************************************");
		//System.out.println("********\t请根据提示进行操作\t\t\t********");
		System.out.println("                 请输入要查询的市");
		String city = input.nextLine();
		System.out.println("********************************************************");
		return city;
	}

////	根据是否返校查询
	public static String selectIsReturn() {
		//System.out.println("********************************************************");
		System.out.println("                 请根据提示进行操作");
		System.out.println("                 请输入是否有疑似症状");
		String IsReturn = input.nextLine();
		System.out.println("******************************************************");
		return IsReturn;
	}

//	根据是否有疑似症状查询
	public static String selectIsSuspect() {
		//System.out.println("********************************************************");
		System.out.println("                 请根据提示进行操作");
		System.out.println("                 请输入是否返校");
		String IsSuspect = input.nextLine();
		System.out.println("******************************************************");
		return IsSuspect;
	}

//查看柱状图
	public static int barMenuView() {
		//System.out.println("********************************************************");
		//System.out.println("********\t请根据提示进行操作\t\t\t********");
		System.out.println("                 1.查看确症人员的柱状图");
		//System.out.println("                 2.查看武汉地区的人员");
		System.out.println("                 2.退出");
		String b = input.nextLine();
		int b1 = Integer.parseInt(b);
		if (b1 < 0 || b1 > 3) {
			System.out.println("输入错误，请重新输入");
			return barMenuView();
		}
		System.out.println("******************************************************");
		return b1;
	}

}
