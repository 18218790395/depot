package com.ssm.mapper;

import java.util.List;

import com.ssm.model.Reader;

public interface ReaderMapper {
	// �ӿ��еķ���ǰ���public abstract ,����ǰ���public static final������ʡ�Եġ�
	// д�˾������࣬��һд���˾��Ǵ���
	// ���Ի��ǲ�д�á�

	// ��ö����б��� û�в�������ΪreaderList.jspҳ��û��Ҫ������������
	List<Reader> readerList();

	// �������鷽�� �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	Reader detailReader(Reader rid);

	// �༭���߷��� �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	void updateReader(Reader rid);

	// ɾ�����߷��� �β�ridΪreaderList.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	void deleteReader(Reader rid);

	// ���Ӷ��߷��� �β�ΪreaderAdd.jspҳ�洫������һ��reader�����reader�ĸ�������Ϊsql����ռλ����ֵ
	void addReader(Reader reader);
}
