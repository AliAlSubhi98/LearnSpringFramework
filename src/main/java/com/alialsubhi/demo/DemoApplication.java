package com.alialsubhi.demo;

import com.alialsubhi.demo.game.GameRunner;
import com.alialsubhi.demo.game.MarioGame;
import com.alialsubhi.demo.game.SuperContraGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		//var marioGame =  new MarioGame();
		var superContraGame = new SuperContraGame();
		var gameRunner = new GameRunner(superContraGame);
		gameRunner.run();

	}

}
