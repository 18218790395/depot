package com.ssm.model;

// ��Ӧ���ݿ��reader������������ֶ�һһ��Ӧ����jspҳ���name����һһ��Ӧ
public class Reader {
	// ����id �������� �����ݿ��������
	private int rid;
	// ������
	private String rname;
	// �Ա�
	private String gender;
	// ��ַ
	private String address;
	// �绰
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
