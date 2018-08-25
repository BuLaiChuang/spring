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
		//读取配置文件
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = ac.getBean(UserMapper.class);
		//演示生成的UserExample用法
		UserExample example = new UserExample();
		String username = "明";
		example.createCriteria().andSexEqualTo("1").andUsernameLike("%"+ username +"%");
		int num = mapper.countByExample(example);
		System.out.println(num);
		List<User> userlist = mapper.selectByExample(example);
		for (User user : userlist) {
			System.out.println(user);
		}
	}
}
