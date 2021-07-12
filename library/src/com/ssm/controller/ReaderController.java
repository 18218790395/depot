package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Reader;
import com.ssm.service.ReaderService;

// 自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean
@Controller
@RequestMapping("reader")
public class ReaderController {

	// 注解注入ReaderService，自动装载bean
	@Autowired
	private ReaderService readerService;

	// 读者列表页面 localhost:8080/library/reader/readerList
	@RequestMapping("readerList")
	public ModelAndView readerList() {
		ModelAndView mv = new ModelAndView();
		// 调用获得读者列表方法，执行相应的sql语句
		List<Reader> readers = readerService.readerList();
		// 把执行sql语句后获得的结果给readerList.jsp用来显示
		mv.addObject("readers", readers);
		// 跳转到读者列表页面 readerList.jsp 默认方式是forward url不变
		mv.setViewName("readerList");
		return mv;
	}

	// 编辑读者 localhost:8080/library/reader/updateReader
	@RequestMapping("updateReader")
	// 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	public ModelAndView updateReader(Reader rid) {
		ModelAndView mv = new ModelAndView();
		// 调用读者详情方法，执行相应的sql语句
		Reader reader = readerService.detailReader(rid);
		// 把执行sql语句后获得的结果给readerEdit.jsp用来显示
		mv.addObject("reader", reader);
		// 跳转到相应编辑读者页面 readerEdit.jsp 默认方式是forward url不变
		mv.setViewName("readerEdit");
		return mv;
	}

	@RequestMapping("readerEdit")
	// 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	public String readerEdit(Reader rid) {
		// 调用编辑读者方法，执行相应的sql语句
		readerService.updateReader(rid);
		// 重定向到读者列表页面 readerList.jsp 方式是redirect url变更
		return "redirect:/reader/readerList";
	}

	// 删除读者 localhost:8080/library/reader/readerList
	@RequestMapping("deleteReader")
	// 形参rid为readerList.jsp页面传进来的数据，这个数据最终作为sql语句的占位符的值
	public String deleteReader(Reader rid) {
		// 调用删除读者方法，执行相应的sql语句
		readerService.deleteReader(rid);
		// 重定向到读者列表页面 readerList.jsp 方式是redirect url变更
		return "redirect:/reader/readerList";
	}

	// 添加图书 localhost:8080/library/reader/addReader
	@RequestMapping("addReader")
	// 形参为bookAdd.jsp页面传进来的一个reader，这个reader的各属性作为sql语句的占位符的值
	public String addReader() {
		// 跳转到添加读者页面 bookAdd.jsp
		return "readerAdd";
	}

	@RequestMapping("readerAdd")
	// 形参为readerAdd.jsp页面传进来的一个reader，这个reader的各字段作为sql语句的占位符的值
	public String readerAdd(Reader reader) {
		// 调用添加图书方法，执行相应的sql语句
		readerService.addReader(reader);
		// 重定向到图书列表页面 readerList.jsp 方式是redirect url变更
		return "redirect:/reader/readerList";
	}

}
