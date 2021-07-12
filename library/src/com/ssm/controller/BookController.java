package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Book;
import com.ssm.service.BookService;

// �Զ�ע�ᵽSpring����������Ҫ����applicationContext.xml�ļ�����bean
@Controller
@RequestMapping("book")
public class BookController {

	// ע��ע��BookService���Զ�װ��bean
	@Autowired
	private BookService bookService;

	// ͨ��ͼ������ý�� localhost:8080/library/book/searchBook
	@RequestMapping("searchBook")
	// �β�bnameΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	public ModelAndView rescarhBook(Book bname) {
		ModelAndView mv = new ModelAndView();
		// ����ͨ��ͼ������ý��������ִ����Ӧ��sql���
		List<Book> books = bookService.searchBook(bname);
		// ��ִ��sql�����õĽ����bookList.jsp������ʾ
		mv.addObject("books", books);
		// ��ת��ͼ���б�ҳ�� bookList.jsp Ĭ�Ϸ�ʽ��forward url����
		mv.setViewName("bookList");
		return mv;
	}

	// ͼ���б�ҳ�� localhost:8080/library/book/bookList
	@RequestMapping("bookList")
	public ModelAndView bookList() {
		ModelAndView mv = new ModelAndView();
		// ���û��ͼ���б�����ִ����Ӧ��sql���
		List<Book> books = bookService.bookList();
		// ��ִ��sql�����õĽ����bookList.jsp������ʾ
		mv.addObject("books", books);
		// ��ת��ͼ���б�ҳ�� bookList.jsp Ĭ�Ϸ�ʽ��forward url����
		mv.setViewName("bookList");
		return mv;
	}

	// ͼ������ localhost:8080/library/book/detailBook
	@RequestMapping("detailBook")
	// �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	public ModelAndView detailBook(Book bid) {
		ModelAndView mv = new ModelAndView();
		// ����ͼ�����鷽����ִ����Ӧ��sql���
		Book book = bookService.detailBook(bid);
		// ��ִ��sql�����õĽ����bookDetail.jsp������ʾ
		mv.addObject("book", book);
		// ��ת����Ӧͼ������ҳ�� bookDetail.jsp Ĭ�Ϸ�ʽ��forward url����
		mv.setViewName("bookDetail");
		return mv;
	}

	// �༭ͼ�� localhost:8080/library/book/updateBook
	@RequestMapping("updateBook")
	// �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	public ModelAndView updateBook(Book bid) {
		ModelAndView mv = new ModelAndView();
		// ����ͼ�����鷽����ִ����Ӧ��sql���
		Book book = bookService.detailBook(bid);
		// ��ִ��sql�����õĽ����bookEdit.jsp������ʾ
		mv.addObject("book", book);
		// ��ת����Ӧ�༭ͼ��ҳ�� bookEdit.jsp Ĭ�Ϸ�ʽ��forward url����
		mv.setViewName("bookEdit");
		return mv;
	}

	@RequestMapping("bookEdit")
	// �β�bidΪbookList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	public String bookEdit(Book bid) {
		// ���ñ༭ͼ�鷽����ִ����Ӧ��sql���
		bookService.updateBook(bid);
		// �ض���ͼ���б�ҳ�� bookList.jsp ��ʽ��redirect url���
		return "redirect:/book/bookList";
	}

	// ɾ��ͼ�� localhost:8080/library/book/bookList
	@RequestMapping("deleteBook")
	// �β�bidΪbookList.jspҳ�洫���������ݣ��������������Ϊsql����ռλ����ֵ
	public String deleteBook(Book bid) {
		// ����ɾ��ͼ�鷽����ִ����Ӧ��sql���
		bookService.deleteBook(bid);
		// �ض���ͼ���б�ҳ�� bookList.jsp ��ʽ��redirect url���
		return "redirect:/book/bookList";
	}

	// ���ͼ�� localhost:8080/library/book/addBook
	@RequestMapping("addBook")
	// �β�ΪbookAdd.jspҳ�洫������һ��book�����һ��book�ĸ�������Ϊsql����ռλ����ֵ
	public String addBook() {
		// ��ת�����ͼ��ҳ�� bookAdd.jsp
		return "bookAdd";
	}

	@RequestMapping("bookAdd")
	// �β�ΪbookAdd.jspҳ�洫������һ��book�����һ��book�ĸ��ֶ���Ϊsql����ռλ����ֵ
	public String bookAdd(Book book) {
		// �������ͼ�鷽����ִ����Ӧ��sql���
		bookService.addBook(book);
		// �ض���ͼ���б�ҳ�� bookList.jsp ��ʽ��redirect url���
		return "redirect:/book/bookList";
	}

}
