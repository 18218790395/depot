package com.ssm.mapper;

import java.util.List;

import com.ssm.model.Book;

public interface BookMapper {
	// 接口中的方法前面的public abstract ,属性前面的public static final都可以省略的。
	// 写了就是冗余，万一写错了就是错误。
	// 所以还是不写好。

	// 通过图书名获得结果方法 形参bname为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	List<Book> searchBook(Book bname);

	// 获得图书列表方法 没有参数，因为bookList.jsp页面没有要传进来的数据
	List<Book> bookList();

	// 图书详情方法 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	Book detailBook(Book bid);

	// 编辑图书方法 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	void updateBook(Book bid);

	// 删除图书方法 形参bid为bookList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	void deleteBook(Book bid);

	// 增加图书方法 形参为bookAdd.jsp页面传进来的一本book，这个一本book的各属性作为sql语句的占位符的值
	void addBook(Book book);
}
