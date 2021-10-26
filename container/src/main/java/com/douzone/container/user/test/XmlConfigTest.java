package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		// XML Auto Configuration(Annotation Scanning)
		// testBeanFactory01();

		// XML Bean Configuration(Explicite Configuration)
		// testBeanFactory02();

		// XML Auto Configuration(Annotation Scanning)
		// testApplicationContext01();

		// XML Bean Configuration(Explicite Configuration)
		testApplicationContext02();
	}

	// XML Bean Configuration(Explicite Configuration)
	private static void testApplicationContext02() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext02.xml");
		User user = null;

		// id로 bean 가져오기
		user = (User) ac.getBean("user");
		System.out.println(user);

		// name으로 bean 가져오기
		user = (User) ac.getBean("usr");
		System.out.println(user);

		// type으로 bean 가져오기
		// 같은 type의 bean이 두개 이상 있으면 type으로 가져오면 Error!!
		// 1. type + id
		// 2. type + name
		user = ac.getBean("user2", User.class);
		System.out.println(user);

		// 2개 parameter로 생성된 빈 가져오기1
		user = ac.getBean("user3", User.class);
		System.out.println(user);

		// 2개 parameter로 생성된 빈 가져오기2
		user = ac.getBean("user4", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기1
		user = ac.getBean("user5", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기2 (DI)
		user = ac.getBean("user6", User.class);
		System.out.println(user);

		// setter를 사용한 빈 가져오기2 (List Property)
		user = ac.getBean("user7", User.class);
		System.out.println(user);
	}

	// XML Auto Configuration(Annotation Scanning)
	private static void testApplicationContext01() {
		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext01.xml");

		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean id가 자동으로 설정됨
		user1 = (User1) ac.getBean("user1");
		System.out.println(user1.getName());
	}

	// XML Auto Configuration(Annotation Scanning)
	private static void testBeanFactory01() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean id가 자동으로 설정됨
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}

	// XML Bean Configuration(Explicite Configuration)
	private static void testBeanFactory02() {
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));
		User1 user1 = bf.getBean(User1.class);
		System.out.println(user1.getName());

		// Bean id가 자동으로 설정되지 않음
		// 명시적으로 id를 설정해줘야 한다
		user1 = (User1) bf.getBean("user1");
		System.out.println(user1.getName());
	}
}
