package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.BookMapper;
import com.ssm.model.Book;
import com.ssm.service.BookService;

// �Զ�ע�ᵽSpring����������Ҫ����applicationContext.xml�ļ�����bean
@Service
// ����ʽ�������
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class BookServiceImpl implements BookService {

	// ע��ע��BookMapper���Զ�װ��bean
	@Autowired
	private BookMapper bookMapper;

	// ͨ��ͼ������ý������ʵ��
	@Override
	// �β�bnameΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public List<Book> searchBook(Book bname) {
		// sql�в�Ĳ�������Ϊ�з���ֵ(resultType="book")������ʵ�ַ���ʱҪ�н�����
		List<Book> books = bookMapper.searchBook(bname);
		return books;
	}

	// ���ͼ���б����ʵ��
	@Override
	// û�в�������ΪbookList.jspҳ��û��Ҫ������������
	public List<Book> bookList() {
		// sql�в�Ĳ�������Ϊ�з���ֵ(resultType="book")������ʵ�ַ���ʱҪ�н�����
		List<Book> books = bookMapper.bookList();
		return books;
	}

	// ͼ���������ʵ��
	@Override
	// �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public Book detailBook(Book bid) {
		// sql�в�Ĳ�������Ϊ�з���ֵ(resultType="book")������ʵ�ַ���ʱҪ�н�����
		Book book = bookMapper.detailBook(bid);
		return book;
	}

	// �༭ͼ�����ʵ��
	@Override
	// �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public void updateBook(Book bid) {
		// sql�иĲ�����û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		bookMapper.updateBook(bid);
	}

	// ɾ��ͼ�����ʵ��
	@Override
	// �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public void deleteBook(Book bid) {
		// sql��ɾ������û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		bookMapper.deleteBook(bid);
	}

	// ���ͼ�����ʵ��
	@Override
	// �β�ΪbookAdd.jspҳ�洫������һ��book�����һ��book�ĸ�������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public void addBook(Book book) {
		// sql����������û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		bookMapper.addBook(book);
	}

}
