package com.ssm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ssm.mapper.UserMapper;
import com.ssm.model.User;
import com.ssm.service.UserService;

// �Զ�ע�ᵽSpring����������Ҫ����applicationContext.xml�ļ�����bean
@Service
// ����ʽ�������
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class UserServiceImpl implements UserService {

	// ע��ע��UserMapper���Զ�װ��bean
	@Autowired
	private UserMapper userMapper;

	// ��¼����ʵ��
	@Override
	// �β�Ϊlogin.jspҳ�����������һ���û����ݣ������˶����ݿ�����Ƿ�������û�
	public User login(User user) {
		// sql�в�Ĳ�������Ϊ�з���ֵ(resultType="user")������ʵ�ַ���ʱҪ�н�����
		User loginuser = userMapper.login(user);
		return loginuser;
	}

	// �����޸ľ���ʵ��
	@Override
	// �β�Ϊlogin.jspҳ�洫���������ݣ����������Ϊsql����ռλ����ֵ
	public void updatePwd(User aid) {
		// sql�иĲ�����û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		userMapper.updatePwd(aid);
	}

	// ע�����ʵ��
	@Override
	// �β�Ϊlogin.jspҳ�����������һ���û����ݣ������������ݿ���У�ʵ��ע�Ṧ��
	public void register(User user) {
		// sql����������û�з���ֵ������ʵ�ַ���ʱ����Ҫ������
		userMapper.register(user);
	}

	// �����û����Ƿ��ظ�����ʵ��
	@Override
	// �β�Ϊregister.jspҳ�洫������һ���û����ݣ����е��û������������˶����ݿ�����Ƿ�������û�
	public User checkAname(User user) {
		// sql�в�Ĳ�������Ϊ�з���ֵ(resultType="user")������ʵ�ַ���ʱҪ�н�����
		User registeruser = userMapper.checkAname(user);
		return registeruser;
	}

}
