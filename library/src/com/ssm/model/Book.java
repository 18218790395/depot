package com.ssm.model;

// 对应数据库的book表，类属性与表字段一一对应，与jsp页面的name属性一一对应
public class Book {
	// 图书id 主键自增 在数据库里好排序 在jsp里并不显示出来
	private int bid;
	// 图书名
	private String bname;
	// 作者
	private String author;
	// 出版社
	private String publish;
	// 价格
	private double price;
	// 剩余数量
	private int num;

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublish() {
		return publish;
	}

	public void setPublish(String publish) {
		this.publish = publish;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
