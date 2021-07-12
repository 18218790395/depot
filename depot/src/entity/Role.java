package entity;

//对应数据库的ROLE表，类属性与表字段一一对应，与jsp页面的name属性一一对应
public class Role {

	private Integer roleid;
	private String rolename;

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
