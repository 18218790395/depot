package com.ssm.model;

// 对应数据库的reader表，类属性与表字段一一对应，与jsp页面的name属性一一对应
public class Reader {
	// 读者id 主键自增 在数据库里好排序
	private int rid;
	// 读者名
	private String rname;
	// 性别
	private String gender;
	// 地址
	private String address;
	// 电话
	private String phone;

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
