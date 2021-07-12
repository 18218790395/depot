package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.BookMapper;
import com.ssm.model.Book;
import com.ssm.service.BookService;

// 自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean
@Service
// 声明式事务管理
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class BookServiceImpl implements BookService {

	// 注解注入BookMapper，自动装载bean
	@Autowired
	private BookMapper bookMapper;

	// 通过图书名获得结果具体实现
	@Override
	// 形参bname为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public List<Book> searchBook(Book bname) {
		// sql中查的操作，因为有返回值(resultType="book")，所以实现方法时要有接收者
		List<Book> books = bookMapper.searchBook(bname);
		return books;
	}

	// 获得图书列表具体实现
	@Override
	// 没有参数，因为bookList.jsp页面没有要传进来的数据
	public List<Book> bookList() {
		// sql中查的操作，因为有返回值(resultType="book")，所以实现方法时要有接收者
		List<Book> books = bookMapper.bookList();
		return books;
	}

	// 图书详情具体实现
	@Override
	// 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public Book detailBook(Book bid) {
		// sql中查的操作，因为有返回值(resultType="book")，所以实现方法时要有接收者
		Book book = bookMapper.detailBook(bid);
		return book;
	}

	// 编辑图书具体实现
	@Override
	// 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public void updateBook(Book bid) {
		// sql中改操作，没有返回值，所以实现方法时不需要接收者
		bookMapper.updateBook(bid);
	}

	// 删除图书具体实现
	@Override
	// 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public void deleteBook(Book bid) {
		// sql中删操作，没有返回值，所以实现方法时不需要接收者
		bookMapper.deleteBook(bid);
	}

	// 添加图书具体实现
	@Override
	// 形参为bookAdd.jsp页面传进来的一本book，这个一本book的各属性作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public void addBook(Book book) {
		// sql中增操作，没有返回值，所以实现方法时不需要接收者
		bookMapper.addBook(book);
	}

}
