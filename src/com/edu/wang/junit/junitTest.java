package com.edu.wang.junit;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.edu.wang.mapper.UserMapper;
import com.edu.wang.pojo.User;
import com.edu.wang.pojo.UserExample;

public class junitTest {

	@Test
	public void test(){
		//��ȡ�����ļ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = ac.getBean(UserMapper.class);
		//��ʾ���ɵ�UserExample�÷�
		UserExample example = new UserExample();
		String username = "��";
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+ username +"%");
		int num = mapper.countByExample(example);
		System.out.println(num);
		List<User> userlist = mapper.selectByExample(example);
		for (User user : userlist) {
			System.out.println(user);
		}
	}
}
