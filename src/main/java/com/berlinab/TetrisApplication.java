package com.berlinab;

import com.berlinab.tetris.Game;
import com.berlinab.tetrisspring.TetrisCommandLineRunner;
import com.berlinab.tetrisui.Gui;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TetrisApplication {

	public static void main(String[] args) {
		SpringApplication.run(TetrisApplication.class, args);
	}

    public TetrisCommandLineRunner commandLineRunner(Game game, Gui gui) {
        return new TetrisCommandLineRunner(game, gui);
    }

    @Bean
    public Game game() {
        return new Game();
    }

    @Bean
    public Gui gui(Game game) {
        return new Gui(game);
    }
}


