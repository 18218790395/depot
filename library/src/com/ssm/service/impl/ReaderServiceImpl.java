package com.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.ReaderMapper;
import com.ssm.model.Reader;
import com.ssm.service.ReaderService;

// �Զ�ע�ᵽSpring����������Ҫ����applicationContext.xml�ļ�����bean
@Service
// ����ʽ�������
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ReaderServiceImpl implements ReaderService {

	// ע��ע��ReaderMapper���Զ�װ��bean
	@Autowired
	private ReaderMapper readerMapper;

	// ��ö����б����ʵ��
	@Override
	// û�в�������ΪreaderList.jspҳ��û��Ҫ������������
	public List<Reader> readerList() {
		// sql�в�Ĳ�������Ϊ�з���ֵ(resultType="reader")������ʵ�ַ���ʱҪ�н�����
		List<Reader> readers = readerMapper.readerList();
		return readers;
	}

	// �����������ʵ��
	@Override
	// �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public Reader detailReader(Reader rid) {
		// sql�в�Ĳ�������Ϊ�з���ֵ(resultType="reader")������ʵ�ַ���ʱҪ�н�����
		Reader reader = readerMapper.detailReader(rid);
		return reader;
	}

	// �༭���߾���ʵ��
	@Override
	// �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public void updateReader(Reader rid) {
		// sql�иĲ�����û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		readerMapper.updateReader(rid);
	}

	// ɾ�����߾���ʵ��
	@Override
	// �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public void deleteReader(Reader rid) {
		// sql��ɾ������û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		readerMapper.deleteReader(rid);
	}

	// ��Ӷ��߾���ʵ��
	@Override
	// �β�ΪreaderAdd.jspҳ�洫������һ��reader�����reader�ĸ�������Ϊsql����ռλ����ֵ
	// ��ռλ����ֵ��λ��sql���Ϳ���ִ�У�ʵ����Ӧ�����Ĺ���
	public void addReader(Reader reader) {
		// sql����������û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		readerMapper.addReader(reader);
	}

}
