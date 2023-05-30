package com.alialsubhi.learnspringframwork.examples.d1;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA{

}
@Component
@Lazy // not running until calling it
class ClassB{
	private ClassA classA;
	public ClassB(ClassA classA){
		// logic
		System.out.println("Initialization Logic");
		this.classA = classA;
	}
	public void doSomething(){
		System.out.println("Do Something !!!");
	}
}

@Configuration
@ComponentScan("com.alialsubhi.learnspringframwork.examples.d1")
@SpringBootApplication
public class LazyInitializationLauncherApplication {

	public static void main(String[] args) {
		//SpringApplication.run(LazyInitializationLauncherApplication.class, args);

		try (var context =
					 new AnnotationConfigApplicationContext
							 (LazyInitializationLauncherApplication.class)) {

			System.out.println("Initialization of context is completed !!!");
			context.getBean(ClassB.class).doSomething();

		}
	}
}
