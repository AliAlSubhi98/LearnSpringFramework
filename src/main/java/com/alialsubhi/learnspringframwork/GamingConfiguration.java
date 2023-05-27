package com.alialsubhi.learnspringframwork;

import com.alialsubhi.learnspringframwork.game.GameRunner;
import com.alialsubhi.learnspringframwork.game.GamingConsole;
import com.alialsubhi.learnspringframwork.game.PacmanGame;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {

    @Bean
    public GamingConsole game(){
        var game = new PacmanGame();
        return game;
    }

    @Bean
    public GameRunner gameRunner(GamingConsole game){
        var gameRunner = new GameRunner(game);
        return gameRunner;
    }
}
