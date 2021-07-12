package com.ssm.mapper;

import java.util.List;

import com.ssm.model.Reader;

public interface ReaderMapper {
	// 接口中的方法前面的public abstract ,属性前面的public static final都可以省略的。
	// 写了就是冗余，万一写错了就是错误。
	// 所以还是不写好。

	// 获得读者列表方法 没有参数，因为readerList.jsp页面没有要传进来的数据
	List<Reader> readerList();

	// 读者详情方法 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	Reader detailReader(Reader rid);

	// 编辑读者方法 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	void updateReader(Reader rid);

	// 删除读者方法 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	void deleteReader(Reader rid);

	// 增加读者方法 形参为readerAdd.jsp页面传进来的一个reader，这个reader的各属性作为sql语句的占位符的值
	void addReader(Reader reader);
}
