package com.ssm.model;

// ��Ӧ���ݿ��book������������ֶ�һһ��Ӧ����jspҳ���name����һһ��Ӧ
public class Book {
	// ͼ��id �������� �����ݿ�������� ��jsp�ﲢ����ʾ����
	private int bid;
	// ͼ����
	private String bname;
	// ����
	private String author;
	// ������
	private String publish;
	// �۸�
	private double price;
	// ʣ������
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
