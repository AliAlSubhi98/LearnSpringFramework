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

	Dependency1 dependency1;
	Dependency2 dependency2;
	@Autowired
	public MyBusinessClass(Dependency1 dependency1, Dependency2 dependency2) {
		super();
		System.out.println("Constructor Injection = MyBusinessClass");

		this.dependency1 = dependency1;
		this.dependency2 = dependency2;
	}

	/*@Autowired
        public void setDependency1(Dependency1 dependency1) {
            System.out.println("Setter Injection = setDependency1");
            this.dependency1 = dependency1;
        }
        @Autowired
        public void setDependency2(Dependency2 dependency2) {
            System.out.println("Setter Injection = setDependency2");

            this.dependency2 = dependency2;
        }
    */
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
