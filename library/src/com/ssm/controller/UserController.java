package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.User;
import com.ssm.service.UserService;

// 自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean
@Controller
@RequestMapping("user")
public class UserController {

	// 注解注入UserService，自动装载bean
	@Autowired
	private UserService userService;

	// 登录页面 localhost:8080/library/user/toLogin
	@RequestMapping("toLogin")
	public String toLogin() {
		// 跳转到登录页面 login.jsp
		return "login";
	}

	// 登录用户信息校验 localhost:8080/library/user/login
	@RequestMapping("login")
	// 形参user为login.jsp页面表单传进来的一个用户数据，用来核对数据库表中是否有这个用户
	public ModelAndView login(User user, HttpSession session) {
		// 控制台打印取得的登录的用户名和密码
		System.out.println(user.getAname() + "___" + user.getPwd());
		ModelAndView mv = new ModelAndView();
		// 调用登录方法 loginuser接收sql(查操作)的结果
		User loginuser = userService.login(user);
		// loginuser = null就代表执行sql语句后没有找到这个用户数据，也就是数据库表中没有这个用户
		if (loginuser == null) {
			// 'errormsg'用于login.jsp页面取得值--"用户名或密码错误"
			mv.addObject("errormsg", "用户名或密码错误");
			// 跳转到登录页面 login.jsp
			mv.setViewName("login");
		} else {
			// 登录的用户信息存入session
			// "user"用于head.jsp页面取得loginuser的值(sql查操作返回的结果)
			session.setAttribute("user", loginuser);
			// 跳转到主页面 index.jsp
			mv.setViewName("index");
		}
		return mv;
	}

	// 密码修改 localhost:8080/library/user/updatePwd
	@RequestMapping("updatePwd")
	public String updatePwd() {
		return "pwdEdit";
	}

	@RequestMapping("pwdEdit")
	public String pwdEdit(User aid) {
		userService.updatePwd(aid);
		// 跳转到登录页面 login.jsp
		return "login";
	}

	// 注册页面 localhost:8080/library/user/toRegister
	@RequestMapping("toRegister")
	public String toRegister() {
		// 跳转到注册页面 register.jsp
		return "register";
	}

	// 注册用户信息校验 localhost:8080/library/user/checkAname
	@RequestMapping("checkAname")
	// 形参user为register.jsp页面传进来的一个用户数据，其中的用户名属性用来核对数据库表中是否有这个用户
	public ModelAndView checkAname(User user, HttpSession session) {
		// 控制台打印取得的注册的用户名和密码
		System.out.println(user.getAname() + "___" + user.getPwd());
		ModelAndView mv = new ModelAndView();
		// 调用检验用户名是否重复方法 registeruser接收sql(查操作)的结果
		User registeruser = userService.checkAname(user);
		// loginuser != null就代表执行sql语句后找到有相关用户名的数据，也就是数据库表中有相关用户名的用户
		if (registeruser != null) {
			// 'repeatmsg'用于register.jsp页面取得值--"用户名已存在"
			mv.addObject("repeatmsg", "用户名已存在");
			// 跳转到注册页面 register.jsp
			mv.setViewName("register");
		} else {
			// 注册用户 形参user为register.jsp页面传进来的一个用户数据，用来存入数据库表中，实现注册功能
			userService.register(user);
			// 跳转到登录页面 login.jsp
			mv.setViewName("login");
		}
		return mv;
	}

	// 主页面 localhost:8080/library/user/index
	@RequestMapping("index")
	public String index() {
		// 跳转到主页面 index.jsp
		return "index";
	}

	// 主页面顶上的菜单 localhost:8080/library/user/head
	@RequestMapping("head")
	public String head() {
		return "head";
	}

	// 注销页面 localhost:8080/library/user/logout
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		// 使session失效
		session.invalidate();
		// 跳转到登录页面 login.jsp
		return "login";
	}
}
