package mapper;

import java.util.List;

import entity.Role;

//接口的所有方法由mapper.xml实现功能(就是CURD)
public interface RoleMapper {

	// 根据职称id(方法参数)查找职位名字方法
	Role selectRoleById(int roleid);

	// 查找所有职称名字方法
	List<Role> listRoles();
}
