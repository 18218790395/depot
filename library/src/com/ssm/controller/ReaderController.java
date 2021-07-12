package com.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssm.model.Reader;
import com.ssm.service.ReaderService;

// �Զ�ע�ᵽSpring����������Ҫ����applicationContext.xml�ļ�����bean
@Controller
@RequestMapping("reader")
public class ReaderController {

	// ע��ע��ReaderService���Զ�װ��bean
	@Autowired
	private ReaderService readerService;

	// �����б�ҳ�� localhost:8080/library/reader/readerList
	@RequestMapping("readerList")
	public ModelAndView readerList() {
		ModelAndView mv = new ModelAndView();
		// ���û�ö����б�����ִ����Ӧ��sql���
		List<Reader> readers = readerService.readerList();
		// ��ִ��sql�����õĽ����readerList.jsp������ʾ
		mv.addObject("readers", readers);
		// ��ת�������б�ҳ�� readerList.jsp Ĭ�Ϸ�ʽ��forward url����
		mv.setViewName("readerList");
		return mv;
	}

	// �༭���� localhost:8080/library/reader/updateReader
	@RequestMapping("updateReader")
	// �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	public ModelAndView updateReader(Reader rid) {
		ModelAndView mv = new ModelAndView();
		// ���ö������鷽����ִ����Ӧ��sql���
		Reader reader = readerService.detailReader(rid);
		// ��ִ��sql�����õĽ����readerEdit.jsp������ʾ
		mv.addObject("reader", reader);
		// ��ת����Ӧ�༭����ҳ�� readerEdit.jsp Ĭ�Ϸ�ʽ��forward url����
		mv.setViewName("readerEdit");
		return mv;
	}

	@RequestMapping("readerEdit")
	// �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	public String readerEdit(Reader rid) {
		// ���ñ༭���߷�����ִ����Ӧ��sql���
		readerService.updateReader(rid);
		// �ض��򵽶����б�ҳ�� readerList.jsp ��ʽ��redirect url���
		return "redirect:/reader/readerList";
	}

	// ɾ������ localhost:8080/library/reader/readerList
	@RequestMapping("deleteReader")
	// �β�ridΪreaderList.jspҳ�洫���������ݣ��������������Ϊsql����ռλ����ֵ
	public String deleteReader(Reader rid) {
		// ����ɾ�����߷�����ִ����Ӧ��sql���
		readerService.deleteReader(rid);
		// �ض��򵽶����б�ҳ�� readerList.jsp ��ʽ��redirect url���
		return "redirect:/reader/readerList";
	}

	// ���ͼ�� localhost:8080/library/reader/addReader
	@RequestMapping("addReader")
	// �β�ΪbookAdd.jspҳ�洫������һ��reader�����reader�ĸ�������Ϊsql����ռλ����ֵ
	public String addReader() {
		// ��ת����Ӷ���ҳ�� bookAdd.jsp
		return "readerAdd";
	}

	@RequestMapping("readerAdd")
	// �β�ΪreaderAdd.jspҳ�洫������һ��reader�����reader�ĸ��ֶ���Ϊsql����ռλ����ֵ
	public String readerAdd(Reader reader) {
		// �������ͼ�鷽����ִ����Ӧ��sql���
		readerService.addReader(reader);
		// �ض���ͼ���б�ҳ�� readerList.jsp ��ʽ��redirect url���
		return "redirect:/reader/readerList";
	}

}
