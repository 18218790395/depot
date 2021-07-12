package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;

// 自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean
@Service
// 声明式事务管理
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserServiceImpl implements UserService {

	// 注解注入UserMapper，自动装载bean
	@Autowired
	private UserMapper userMapper;

	// 登录具体实现
	@Override
	// 形参为login.jsp页面表单传进来的一个用户数据，用来核对数据库表中是否有这个用户
	public User login(User user) {
		// sql中查的操作，因为有返回值(resultType="user")，所以实现方法时要有接收者
		User loginuser = userMapper.login(user);
		return loginuser;
	}

	// 密码修改具体实现
	@Override
	// 形参为login.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	public void updatePwd(User aid) {
		// sql中改操作，没有返回值，所以实现方法时不需要接收者
		userMapper.updatePwd(aid);
	}

	// 注册具体实现
	@Override
	// 形参为login.jsp页面表单传进来的一个用户数据，用来存入数据库表中，实现注册功能
	public void register(User user) {
		// sql中增操作，没有返回值，所以实现方法时不需要接收者
		userMapper.register(user);
	}

	// 检验用户名是否重复具体实现
	@Override
	// 形参为register.jsp页面传进来的一个用户数据，其中的用户名属性用来核对数据库表中是否有这个用户
	public User checkAname(User user) {
		// sql中查的操作，因为有返回值(resultType="user")，所以实现方法时要有接收者
		User registeruser = userMapper.checkAname(user);
		return registeruser;
	}

}
