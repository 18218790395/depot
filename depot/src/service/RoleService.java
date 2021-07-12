package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mapper.RoleMapper;
import entity.Role;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class RoleService {

	@Autowired
	private RoleMapper roleMapper;

	// mapper接口的具体实现(将mapper接口与mapper.xml文件相结合)
	public List<Role> listRoles() {
		return roleMapper.listRoles();
	}

}
