package com.douzone.container.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.config.user.AppConfig01;
import com.douzone.container.user.User;

public class AppConfigTest {
	public static void main(String[] args) {
		//testAppConfig01();
		testAppConfig02();
	}

	// Java Config01
	// 직접 자바 클래스(Config class)를 전달
	// 설정 클래스 @Configuration
	private static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);

		User user = ac.getBean(User.class);
		System.out.println(user);
	}

	// Java Config02
	// 자바 설정클래스가 있는 베이스 패키지 전달
	// 설정 클래스 @Configuration 반드시 필요!!
	private static void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.douzone.container.config.user");

		User user = ac.getBean(User.class);
		System.out.println(user);
	}
}
