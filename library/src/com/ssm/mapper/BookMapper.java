package com.ssm.mapper;

import java.util.List;

import com.ssm.model.Book;

public interface BookMapper {
	// �ӿ��еķ���ǰ���public abstract ,����ǰ���public static final������ʡ�Եġ�
	// д�˾������࣬��һд���˾��Ǵ���
	// ���Ի��ǲ�д�á�

	// ͨ��ͼ������ý������ �β�bnameΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	List<Book> searchBook(Book bname);

	// ���ͼ���б��� û�в�������ΪbookList.jspҳ��û��Ҫ������������
	List<Book> bookList();

	// ͼ�����鷽�� �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	Book detailBook(Book bid);

	// �༭ͼ�鷽�� �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	void updateBook(Book bid);

	// ɾ��ͼ�鷽�� �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	void deleteBook(Book bid);

	// ����ͼ�鷽�� �β�ΪbookAdd.jspҳ�洫������һ��book�����һ��book�ĸ�������Ϊsql����ռλ����ֵ
	void addBook(Book book);
}
