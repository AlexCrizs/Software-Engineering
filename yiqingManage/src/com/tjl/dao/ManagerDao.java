package com.tjl.dao;

import com.tjl.bean.Manager;
import com.tjl.bean.User;

public interface ManagerDao {
//	验证登录
	int login(Manager manager);

//	增加新的用户信息
	boolean insert(User user);

//	删除用户信息
	boolean delete(String stuid);

//	查询用户信息
//	根据学院进行查询
	User select(String college);

//	 根据用户所在市进行查询
	User selectCity(String city);

//	 根据用户是否返校查询
	User selectIsReturn(String IsReturn);

//	 根据用户是否有疑似症状查询
	User selectIsSuspect(String IsSuspect);

}
