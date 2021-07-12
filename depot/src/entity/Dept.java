package entity;

//对应数据库的SECTOR表，类属性与表字段一一对应，与jsp页面的name属性一一对应
public class Dept {

	private Integer deptid;
	private String deptname;

	public Integer getDeptid() {
		return deptid;
	}

	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
