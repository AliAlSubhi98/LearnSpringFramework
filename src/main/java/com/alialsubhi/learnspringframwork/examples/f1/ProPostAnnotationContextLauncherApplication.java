package com.alialsubhi.learnspringframwork.examples.f1;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class SomeClass{
	private SomeDependency someDependency;

	public SomeClass(SomeDependency someDependency){
		super();
		this.someDependency=someDependency;
		System.out.println("ALL Dependencies are Ready !!!");
	}
	@PostConstruct
	public void initialize(){
		someDependency.getReady();
	}

	@PreDestroy
	public void cleanup(){
		System.out.println("Cleanup !!");
	}

}
@Component
class SomeDependency {
	public void getReady() {
		System.out.println("Some Logic using someDependency !");
	}
}


@Configuration
@ComponentScan("com.alialsubhi.learnspringframwork.examples.f1")
@SpringBootApplication
public class ProPostAnnotationContextLauncherApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProPostAnnotationContextLauncherApplication.class, args);

		try (var context =
					 new AnnotationConfigApplicationContext
							 (ProPostAnnotationContextLauncherApplication.class)) {

			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

		}
	}
}
