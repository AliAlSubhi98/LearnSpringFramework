package com.alialsubhi.learnspringframwork.examples.c1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
@ComponentScan("com.alialsubhi.learnspringframwork.examples.c1")
@SpringBootApplication
public class RealWorldSimpleSpringContextLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(RealWorldSimpleSpringContextLauncherApplication.class, args);

		try (var context =
					 new AnnotationConfigApplicationContext
							 (RealWorldSimpleSpringContextLauncherApplication.class)) {

		/*	Arrays.stream(context.getBeanDefinitionNames())
					.forEach(System.out::println);
			*/

			System.out.println(
					context.getBean(BusinessCalculationService.class).findMax());

		}
	}
}
