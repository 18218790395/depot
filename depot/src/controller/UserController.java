package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import entity.Dept;
import entity.Role;
import entity.User;
import service.DeptService;
import service.RoleService;
import service.UserService;
import utils.Constants;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private DeptService deptServcie;

	// 登录页面
	@RequestMapping("login")
	public String login() {
		// 跳转到登录页面 login.jsp
		return "login";
	}

	// 登录用户信息校验
	@RequestMapping("toLogin")
	// 形参user为login.jsp页面表单传进来的一个用户数据，用来核对数据库表中是否有这个用户
	public ModelAndView toLogin(User user, HttpSession session) {
		// 控制台打印取得的登录的用户名和密码
		System.out.println(user.getUsername() + "________" + user.getPassword());
		ModelAndView mv = new ModelAndView();
		// 调用登录方法 loginuser接收sql(查操作)的结果
		User loginuser = userService.login(user);
		// loginuser = null就代表执行sql语句后没有找到这个用户数据，也就是数据库表中没有这个用户
		if (loginuser == null) {
			// 'msg'用于login.jsp页面取得值--"用户名密码错误"
			mv.addObject("msg", "用户名密码错误");
			// 转发到登录页面 login.jsp
			mv.setViewName("login");
		} else {
			// 登录的用户信息存入session
			// "loginuser"用于index.jsp页面取得loginuser的值(sql查操作返回的结果)
			session.setAttribute("loginuser", loginuser);
			// 转发到主页面
			mv.setViewName("index");
		}
		return mv;
	}

	// 主页面
	@RequestMapping("index")
	public String index() {
		return "index";
	}

	// index.jsp中主面板，菜单显示页面，假统计
	@RequestMapping("main")
	public String main() {
		return "main";
	}

	// 注销页面
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		// 使session失效
		session.invalidate();
		// 跳转到登录页面
		return "login";
	}

	// 用户注册保存
	@RequestMapping("register")
	public String register(User user) {
		userService.register(user);
		return "login";
	}

	// 用户管理列表查询
	@RequestMapping("listUsers")
	public ModelAndView listUsers(@RequestParam(defaultValue = "1") Integer pageNum, User user,
			HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("user_list");
		// 存入请求的地址
		String uri = request.getRequestURI();
		mv.addObject("uri", uri);
		PageInfo<User> page = new PageInfo<User>();
		page.setPageNum(pageNum);
		page.setPageSize(Constants.PAGESIZE);
		PageInfo<User> userpage = userService.listUsers(page, user);
		mv.addObject("pageInfo", userpage);
		mv.addObject("searchdata", user);
		return mv;
	}

	// 添加用户页面
	@RequestMapping("toAddUser")
	public ModelAndView toAddUser() {
		ModelAndView mv = new ModelAndView("user_add");
		// 查询所有角色
		List<Role> roles = roleService.listRoles();
		// 查询所有的部门
		List<Dept> depts = deptServcie.listDepts();
		mv.addObject("roles", roles);
		mv.addObject("depts", depts);
		return mv;
	}

	// 添加用户,保存信息
	@RequestMapping("addUser")
	public String addUser(User user) {
		userService.addUser(user);
		return "redirect:/user/listUsers";
	}

	// 校验姓名是否重复
	@ResponseBody
	@RequestMapping("checkUsername")
	public String checkUsername(User user) {
		String msg = "notExist";
		boolean flag = userService.checkUsername(user);
		if (flag) {
			msg = "isExist";
		}
		System.out.println("msg=====" + msg);
		return msg;
	}

	// 修改用户，获取用户信息
	@RequestMapping("getUserById")
	public ModelAndView getUserById(User userid) {
		ModelAndView mv = new ModelAndView("user_edit");
		// 查询所有角色
		List<Role> roles = roleService.listRoles();
		// 查询所有的部门
		List<Dept> depts = deptServcie.listDepts();
		// 查询当用户信息
		User user = userService.getUserById(userid);
		mv.addObject("roles", roles);
		mv.addObject("depts", depts);
		mv.addObject("user", user);
		return mv;
	}

	// 修改用户，信息保存
	@RequestMapping("updateUser")
	public String updateUser(User user) {
		userService.updateUser(user);
		return "redirect:/user/listUsers";
	}

	// 删除用户
	@RequestMapping("deleteUserById")
	public String deleteUserById(User userid) {
		userService.deleteUserById(userid);
		return "redirect:/user/listUsers";
	}

}
