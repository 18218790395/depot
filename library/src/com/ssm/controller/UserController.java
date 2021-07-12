package com.ssm.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.User;
import com.ssm.service.UserService;

// �Զ�ע�ᵽSpring����������Ҫ����applicationContext.xml�ļ�����bean
@Controller
@RequestMapping("user")
public class UserController {

	// ע��ע��UserService���Զ�װ��bean
	@Autowired
	private UserService userService;

	// ��¼ҳ�� localhost:8080/library/user/toLogin
	@RequestMapping("toLogin")
	public String toLogin() {
		// ��ת����¼ҳ�� login.jsp
		return "login";
	}

	// ��¼�û���ϢУ�� localhost:8080/library/user/login
	@RequestMapping("login")
	// �β�userΪlogin.jspҳ�����������һ���û����ݣ������˶����ݿ�����Ƿ�������û�
	public ModelAndView login(User user, HttpSession session) {
		// ����̨��ӡȡ�õĵ�¼���û���������
		System.out.println(user.getAname() + "___" + user.getPwd());
		ModelAndView mv = new ModelAndView();
		// ���õ�¼���� loginuser����sql(�����)�Ľ��
		User loginuser = userService.login(user);
		// loginuser = null�ʹ���ִ��sql����û���ҵ�����û����ݣ�Ҳ�������ݿ����û������û�
		if (loginuser == null) {
			// 'errormsg'����login.jspҳ��ȡ��ֵ--"�û������������"
			mv.addObject("errormsg", "�û������������");
			// ��ת����¼ҳ�� login.jsp
			mv.setViewName("login");
		} else {
			// ��¼���û���Ϣ����session
			// "user"����head.jspҳ��ȡ��loginuser��ֵ(sql��������صĽ��)
			session.setAttribute("user", loginuser);
			// ��ת����ҳ�� index.jsp
			mv.setViewName("index");
		}
		return mv;
	}

	// �����޸� localhost:8080/library/user/updatePwd
	@RequestMapping("updatePwd")
	public String updatePwd() {
		return "pwdEdit";
	}

	@RequestMapping("pwdEdit")
	public String pwdEdit(User aid) {
		userService.updatePwd(aid);
		// ��ת����¼ҳ�� login.jsp
		return "login";
	}

	// ע��ҳ�� localhost:8080/library/user/toRegister
	@RequestMapping("toRegister")
	public String toRegister() {
		// ��ת��ע��ҳ�� register.jsp
		return "register";
	}

	// ע���û���ϢУ�� localhost:8080/library/user/checkAname
	@RequestMapping("checkAname")
	// �β�userΪregister.jspҳ�洫������һ���û����ݣ����е��û������������˶����ݿ�����Ƿ�������û�
	public ModelAndView checkAname(User user, HttpSession session) {
		// ����̨��ӡȡ�õ�ע����û���������
		System.out.println(user.getAname() + "___" + user.getPwd());
		ModelAndView mv = new ModelAndView();
		// ���ü����û����Ƿ��ظ����� registeruser����sql(�����)�Ľ��
		User registeruser = userService.checkAname(user);
		// loginuser != null�ʹ���ִ��sql�����ҵ�������û��������ݣ�Ҳ�������ݿ����������û������û�
		if (registeruser != null) {
			// 'repeatmsg'����register.jspҳ��ȡ��ֵ--"�û����Ѵ���"
			mv.addObject("repeatmsg", "�û����Ѵ���");
			// ��ת��ע��ҳ�� register.jsp
			mv.setViewName("register");
		} else {
			// ע���û� �β�userΪregister.jspҳ�洫������һ���û����ݣ������������ݿ���У�ʵ��ע�Ṧ��
			userService.register(user);
			// ��ת����¼ҳ�� login.jsp
			mv.setViewName("login");
		}
		return mv;
	}

	// ��ҳ�� localhost:8080/library/user/index
	@RequestMapping("index")
	public String index() {
		// ��ת����ҳ�� index.jsp
		return "index";
	}

	// ��ҳ�涥�ϵĲ˵� localhost:8080/library/user/head
	@RequestMapping("head")
	public String head() {
		return "head";
	}

	// ע��ҳ�� localhost:8080/library/user/logout
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		// ʹsessionʧЧ
		session.invalidate();
		// ��ת����¼ҳ�� login.jsp
		return "login";
	}
}
