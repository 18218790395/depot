package com.ssm.model;

// 对应数据库的Auser表，类属性与表字段一一对应，与jsp页面的name属性一一对应
public class User {
	// 用户id 主键自增 在数据库里好排序 在jsp里并不显示出来
	private int aid;
	// 用户名
	private String aname;
	// 密码
	private String pwd;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public String getAname() {
		return aname;
	}

	public void setAname(String aname) {
		this.aname = aname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

}
