package com.ssm.mapper;

import com.ssm.model.User;

public interface UserMapper {
	// 接口中的方法前面的public abstract ,属性前面的public static final都可以省略的。
	// 写了就是冗余，万一写错了就是错误。
	// 所以还是不写好。

	// 登录方法 形参为login.jsp页面传进来的一个用户数据，用来核对数据库表中是否有这个用户
	User login(User user);

	// 密码修改方法 形参aid为login.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	void updatePwd(User aid);

	// 注册方法 形参为register.jsp页面传进来的一个用户数据，用来存入数据库表中，实现注册功能
	void register(User user);

	// 检验用户名是否重复方法 形参为register.jsp页面传进来的一个用户数据，其中的用户名属性用来核对数据库表中是否有这个用户
	User checkAname(User user);
}
