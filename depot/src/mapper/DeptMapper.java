package mapper;

import java.util.List;

import entity.Dept;

//接口的所有方法由mapper.xml实现功能(就是CURD)
public interface DeptMapper {

	// 根据部门id(方法参数)查找部门名字方法
	Dept selectDeptById(int deptid);

	// 查找所有部门名字方法
	List<Dept> listDepts();
}
