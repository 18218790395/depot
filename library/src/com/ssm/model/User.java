package com.ssm.model;

// ��Ӧ���ݿ��Auser������������ֶ�һһ��Ӧ����jspҳ���name����һһ��Ӧ
public class User {
	// �û�id �������� �����ݿ�������� ��jsp�ﲢ����ʾ����
	private int aid;
	// �û���
	private String aname;
	// ����
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
