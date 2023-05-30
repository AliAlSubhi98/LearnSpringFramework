package com.alialsubhi.learnspringframwork.examples.a1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;
@Component
class MyBusinessClass{

	// Field Injection no setters or constructor
	@Autowired
	Dependency1 dependency1;
	@Autowired
	Dependency2 dependency2;



	public String toString(){
		return "using " + dependency1 + " and " + dependency2;
	}

}
@Component
class Dependency1{

}
@Component
class Dependency2{

}
@Configuration
@ComponentScan("com.alialsubhi.learnspringframwork.examples.a1")
@SpringBootApplication
public class DepInjectionLauncherApplication {

	public static void main(String[] args) {
		//SpringApplication.run(DepInjectionLauncherApplication.class, args);

		try (var context =
					 new AnnotationConfigApplicationContext
							 (DepInjectionLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

			System.out.println(context.getBean(MyBusinessClass.class));
		}
	}
}
