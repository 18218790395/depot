package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.ReaderMapper;
import com.ssm.model.Reader;
import com.ssm.service.ReaderService;

// 自动注册到Spring容器，不需要再在applicationContext.xml文件定义bean
@Service
// 声明式事务管理
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ReaderServiceImpl implements ReaderService {

	// 注解注入ReaderMapper，自动装载bean
	@Autowired
	private ReaderMapper readerMapper;

	// 获得读者列表具体实现
	@Override
	// 没有参数，因为readerList.jsp页面没有要传进来的数据
	public List<Reader> readerList() {
		// sql中查的操作，因为有返回值(resultType="reader")，所以实现方法时要有接收者
		List<Reader> readers = readerMapper.readerList();
		return readers;
	}

	// 读者详情具体实现
	@Override
	// 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public Reader detailReader(Reader rid) {
		// sql中查的操作，因为有返回值(resultType="reader")，所以实现方法时要有接收者
		Reader reader = readerMapper.detailReader(rid);
		return reader;
	}

	// 编辑读者具体实现
	@Override
	// 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public void updateReader(Reader rid) {
		// sql中改操作，没有返回值，所以实现方法时不需要接收者
		readerMapper.updateReader(rid);
	}

	// 删除读者具体实现
	@Override
	// 形参rid为readerList.jsp页面传进来的数据，这个数据作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public void deleteReader(Reader rid) {
		// sql中删操作，没有返回值，所以实现方法时不需要接收者
		readerMapper.deleteReader(rid);
	}

	// 添加读者具体实现
	@Override
	// 形参为readerAdd.jsp页面传进来的一个reader，这个reader的各属性作为sql语句的占位符的值
	// 待占位符的值到位，sql语句就可以执行，实现相应方法的功能
	public void addReader(Reader reader) {
		// sql中增操作，没有返回值，所以实现方法时不需要接收者
		readerMapper.addReader(reader);
	}

}
