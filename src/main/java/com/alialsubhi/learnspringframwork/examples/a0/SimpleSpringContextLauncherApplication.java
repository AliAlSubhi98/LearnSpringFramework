package com.alialsubhi.learnspringframwork.examples.a0;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.alialsubhi.learnspringframwork.examples.a1")
@SpringBootApplication
public class SimpleSpringContextLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleSpringContextLauncherApplication.class, args);

		try (var context =
					 new AnnotationConfigApplicationContext
							 (SimpleSpringContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}
}
