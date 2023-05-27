package com.alialsubhi.demo;

import com.alialsubhi.demo.game.GameRunner;
import com.alialsubhi.demo.game.PacmanGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.lang.reflect.Array;
import java.util.Arrays;

@SpringBootApplication
public class App02HelloWorldSpring {

	public static void main(String[] args) {
		SpringApplication.run(App02HelloWorldSpring.class, args);

		// 1: Lunch a Spring Context
		var context =
				new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);

		// 2: Configure the things that we want Spring to manage - @Configuration
		//HelloWorldConfiguration - @Configuration
		// name @Bean


		// 3: Retrieving Beans managed by Spring
		System.out.println(context.getBean("name"));
		System.out.println(context.getBean("age"));
		System.out.println(context.getBean("person"));
		System.out.println(context.getBean("address2"));
		System.out.println(context.getBean("person2MethodCall"));
		System.out.println(context.getBean("person3Parameters"));

		System.out.println(context.getBean(Person.class));
		System.out.println(context.getBean(Address.class));


		//how to list all beans manged by Spring framework
		//System.out.println
		Arrays.stream(context.getBeanDefinitionNames())
				.forEach(System.out::println);

		System.out.println(context.getBean("person5Qualifier"));




	}

}
