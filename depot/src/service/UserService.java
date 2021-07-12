package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mapper.UserMapper;
import entity.User;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserService {

	@Autowired
	private UserMapper userMapper;

	// mapper接口的具体实现(将mapper接口与mapper.xml文件相结合)
	public User login(User user) {
		User loginuser = userMapper.login(user);
		return loginuser;
	}

	public void register(User user) {
		userMapper.register(user);
	}

	public boolean checkUsername(User user) {
		boolean flag = false;
		int num = userMapper.checkUsername(user);
		System.out.println(num + "____" + user.getUsername());
		if (num > 0) {// 存在
			flag = true;
		}
		return flag;
	}

	public PageInfo<User> listUsers(PageInfo<User> page, User user) {
		// 设置分页条件
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<User> users = userMapper.listUsers(user);
		// 用PageInfo对结果进行包装
		page = new PageInfo<User>(users);
		return page;
	}

	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public void deleteUserById(User userid) {
		userMapper.deleteUserById(userid);
	}

	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	public User getUserById(User userid) {
		User user = userMapper.getUserById(userid);
		return user;
	}

}
