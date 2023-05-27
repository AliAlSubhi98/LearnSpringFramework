package com.alialsubhi.learnspringframwork;

import com.alialsubhi.learnspringframwork.game.GameRunner;
import com.alialsubhi.learnspringframwork.game.GamingConsole;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class App03GamingSpringBeans {

	public static void main(String[] args) {
		SpringApplication.run(App03GamingSpringBeans.class, args);

		try (var context =
					 new AnnotationConfigApplicationContext
							 (GamingConfiguration.class)) {

			context.getBean(GamingConsole.class).up();

			context.getBean(GameRunner.class).run();

		}
	}
}
