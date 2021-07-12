package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Book;
import com.ssm.service.BookService;

// 自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean
@Controller
@RequestMapping("book")
public class BookController {

	// 注解注入BookService，自动装载bean
	@Autowired
	private BookService bookService;

	// 通过图书名获得结果 localhost:8080/library/book/searchBook
	@RequestMapping("searchBook")
	// 形参bname为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	public ModelAndView rescarhBook(Book bname) {
		ModelAndView mv = new ModelAndView();
		// 调用通过图书名获得结果方法，执行相应的sql语句
		List<Book> books = bookService.searchBook(bname);
		// 把执行sql语句后获得的结果给bookList.jsp用来显示
		mv.addObject("books", books);
		// 跳转到图书列表页面 bookList.jsp 默认方式是forward url不变
		mv.setViewName("bookList");
		return mv;
	}

	// 图书列表页面 localhost:8080/library/book/bookList
	@RequestMapping("bookList")
	public ModelAndView bookList() {
		ModelAndView mv = new ModelAndView();
		// 调用获得图书列表方法，执行相应的sql语句
		List<Book> books = bookService.bookList();
		// 把执行sql语句后获得的结果给bookList.jsp用来显示
		mv.addObject("books", books);
		// 跳转到图书列表页面 bookList.jsp 默认方式是forward url不变
		mv.setViewName("bookList");
		return mv;
	}

	// 图书详情 localhost:8080/library/book/detailBook
	@RequestMapping("detailBook")
	// 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	public ModelAndView detailBook(Book bid) {
		ModelAndView mv = new ModelAndView();
		// 调用图书详情方法，执行相应的sql语句
		Book book = bookService.detailBook(bid);
		// 把执行sql语句后获得的结果给bookDetail.jsp用来显示
		mv.addObject("book", book);
		// 跳转到相应图书详情页面 bookDetail.jsp 默认方式是forward url不变
		mv.setViewName("bookDetail");
		return mv;
	}

	// 编辑图书 localhost:8080/library/book/updateBook
	@RequestMapping("updateBook")
	// 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	public ModelAndView updateBook(Book bid) {
		ModelAndView mv = new ModelAndView();
		// 调用图书详情方法，执行相应的sql语句
		Book book = bookService.detailBook(bid);
		// 把执行sql语句后获得的结果给bookEdit.jsp用来显示
		mv.addObject("book", book);
		// 跳转到相应编辑图书页面 bookEdit.jsp 默认方式是forward url不变
		mv.setViewName("bookEdit");
		return mv;
	}

	@RequestMapping("bookEdit")
	// 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	public String bookEdit(Book bid) {
		// 调用编辑图书方法，执行相应的sql语句
		bookService.updateBook(bid);
		// 重定向到图书列表页面 bookList.jsp 方式是redirect url变更
		return "redirect:/book/bookList";
	}

	// 删除图书 localhost:8080/library/book/bookList
	@RequestMapping("deleteBook")
	// 形参bid为bookList.jsp页面传进来的数据，这个数据最终作为sql语句的占位符的值
	public String deleteBook(Book bid) {
		// 调用删除图书方法，执行相应的sql语句
		bookService.deleteBook(bid);
		// 重定向到图书列表页面 bookList.jsp 方式是redirect url变更
		return "redirect:/book/bookList";
	}

	// 添加图书 localhost:8080/library/book/addBook
	@RequestMapping("addBook")
	// 形参为bookAdd.jsp页面传进来的一本book，这个一本book的各属性作为sql语句的占位符的值
	public String addBook() {
		// 跳转到添加图书页面 bookAdd.jsp
		return "bookAdd";
	}

	@RequestMapping("bookAdd")
	// 形参为bookAdd.jsp页面传进来的一本book，这个一本book的各字段作为sql语句的占位符的值
	public String bookAdd(Book book) {
		// 调用添加图书方法，执行相应的sql语句
		bookService.addBook(book);
		// 重定向到图书列表页面 bookList.jsp 方式是redirect url变更
		return "redirect:/book/bookList";
	}

}
