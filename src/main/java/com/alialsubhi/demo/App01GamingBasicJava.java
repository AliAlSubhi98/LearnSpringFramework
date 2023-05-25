package com.alialsubhi.demo;

import com.alialsubhi.demo.game.GameRunner;
import com.alialsubhi.demo.game.PacmanGame;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App01GamingBasicJava {

	public static void main(String[] args) {
		SpringApplication.run(App01GamingBasicJava.class, args);
/*
### Tight Coupling vs Loose Coupling
* **Tight Coupling:** When two classes are tightly coupled, they are dependent on each other. If one class changes, the other class will also change.

* **Loose Coupling:** When two classes are loosely coupled, they are not dependent on each other. If one class changes, the other class will not change.

In the example below, GameRunner class has a dependency on GamingConsole. Instead of wiring game object to a specific class such as MarioGame, we can use GamingConsole interface to make it loosely coupled. So that, we don't need to change our original code. In the future, we can create classes that implements GamingConsole interface (Polymorphism) and use it.

 */
		//var game =  new MarioGame();
		//var game = new SuperContraGame();
		var game = new PacmanGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();

	}

}
