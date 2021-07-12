package mapper;

import java.util.List;

import entity.User;

// 接口的所有方法由mapper.xml实现功能(就是CURD)
public interface UserMapper {

	// 登录方法
	User login(User user);

	// 注册方法
	void register(User user);

	// 查询所有用户方法
	List<User> listUsers(User user);

	// 检验用户名是否重复方法
	int checkUsername(User user);

	// 添加用户方法
	void addUser(User user);

	// 根据用户id删除相应信息方法
	void deleteUserById(User userid);

	// 修改用户信息方法
	void updateUser(User user);

	// 根据用户id查找用户方法
	User getUserById(User userid);

}
