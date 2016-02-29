package com.berlinab.tetrisspring;

import com.berlinab.tetris.Game;
import com.berlinab.tetrisui.Gui;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class TetrisCommandLineRunner implements CommandLineRunner {
    private final Game game;
    private final Gui gui;

    @Autowired
    public TetrisCommandLineRunner(Game game, Gui gui) {
        this.game = game;
        this.gui = gui;
    }

    @Override
    public void run(String... args) throws Exception {
        game.start();

        while(game.started()) {
            game.tick();

            Thread.sleep(1000);

            gui.draw().stream().forEach(line -> {
                System.out.println(line);
            });
        }
    }
}
