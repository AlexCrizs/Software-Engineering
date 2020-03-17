package com.tjl.bean;

public class Manager {
	private int uid;
	private String username;
	private String password;
	private int type;

	public Manager(int uid, String username, String upass, int type) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = upass;
		this.type = type;
	}

	public Manager(String username, String upass, int type) {
		super();
		this.username = username;
		this.password = upass;
		this.type = type;
	}

	public Manager(String username, String upass) {
		super();
		this.username = username;
		this.password = upass;
	}

	public Manager() {
		super();
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return username;
	}

	public void setUname(String username) {
		this.username = username;
	}

	public String getUpass() {
		return password;
	}

	public void setUpass(String password) {
		this.password = password;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Manager [uid=" + uid + ", username=" + username + ", password=" + password + ", type=" + type + "]";
	}

}
