package com.ssm.mapper;

import com.ssm.model.User;

public interface UserMapper {
	// �ӿ��еķ���ǰ���public abstract ,����ǰ���public static final������ʡ�Եġ�
	// д�˾������࣬��һд���˾��Ǵ���
	// ���Ի��ǲ�д�á�

	// ��¼���� �β�Ϊlogin.jspҳ�洫������һ���û����ݣ������˶����ݿ�����Ƿ�������û�
	User login(User user);

	// �����޸ķ��� �β�aidΪlogin.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	void updatePwd(User aid);

	// ע�᷽�� �β�Ϊregister.jspҳ�洫������һ���û����ݣ������������ݿ���У�ʵ��ע�Ṧ��
	void register(User user);

	// �����û����Ƿ��ظ����� �β�Ϊregister.jspҳ�洫������һ���û����ݣ����е��û������������˶����ݿ�����Ƿ�������û�
	User checkAname(User user);
}
