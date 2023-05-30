package com.alialsubhi.learnspringframwork.game;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.alialsubhi.learnspringframwork.game")
@SpringBootApplication
public class GamingAppLauncherApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamingAppLauncherApplication.class, args);

		try (var context =
					 new AnnotationConfigApplicationContext
							 (GamingAppLauncherApplication.class)) {

			context.getBean(GamingConsole.class).up();

			context.getBean(GameRunner.class).run();

		}
	}
}
