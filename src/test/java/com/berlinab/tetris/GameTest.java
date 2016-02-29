package com.berlinab.tetris;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;

public class GameTest {

    @Test
    public void itCanStartANewGame() throws Exception {
        Game game = new Game();
        assertThat(game.started(), equalTo(false));
        game.start();
        assertThat(game.started(), equalTo(true));
    }

    @Test
    public void itCanBePaused() {
        Game game = new Game();
        game.start();
        game.pause();
        assertThat(game.started(), equalTo(false));
    }

    @Test
    public void itCanProvideTheGameBoard() {
        Game game = new Game();
        assertThat(game.board(), notNullValue());
    }

    @Test
    public void itCanStartALogAtTheTopLeft() throws Exception {
        Game game = new Game();
        game.start();

        assertThat(game.at(0,17).isFilled(), equalTo(false));
        assertThat(game.at(1,17).isFilled(), equalTo(false));
        assertThat(game.at(0,16).isFilled(), equalTo(false));

        game.tick();

        assertThat(game.at(0,17).isFilled(), equalTo(true));
        assertThat(game.at(1,17).isFilled(), equalTo(false));
        assertThat(game.at(0,16).isFilled(), equalTo(false));

    }

    @Test
    public void itMovesTheLogDownTwoSpacesAfterTwoTicks() {
        Game game = new Game();
        game.start();

        game.tick();
        game.tick();

        assertThat(game.at(0,17).isFilled(), equalTo(true));
        assertThat(game.at(0,16).isFilled(), equalTo(true));
        assertThat(game.at(1,17).isFilled(), equalTo(false));
        assertThat(game.at(1,16).isFilled(), equalTo(false));
    }

    @Test
    public void itMovesTheLogDownFiveSpacesAfterFiveTicks() {
        Game game = new Game();
        game.start();

        game.tick();
        game.tick();
        game.tick();
        game.tick();
        game.tick();

        // Column 1
        assertThat(game.at(0,17).isFilled(), equalTo(false));
        assertThat(game.at(0,16).isFilled(), equalTo(true));
        assertThat(game.at(0,15).isFilled(), equalTo(true));
        assertThat(game.at(0,14).isFilled(), equalTo(true));
        assertThat(game.at(0,13).isFilled(), equalTo(true));
        assertThat(game.at(0,12).isFilled(), equalTo(false));

        // Column 2
        assertThat(game.at(1,17).isFilled(), equalTo(false));
        assertThat(game.at(1,16).isFilled(), equalTo(false));
        assertThat(game.at(1,15).isFilled(), equalTo(false));
        assertThat(game.at(1,14).isFilled(), equalTo(false));
        assertThat(game.at(1,13).isFilled(), equalTo(false));
        assertThat(game.at(1,12).isFilled(), equalTo(false));
    }

    @Test
    public void itMovesTheLogDownToTheBottom() {
        Game game = new Game();
        game.start();

        tickNTimes(game, 18);

        // Column 1
        assertThat(game.at(0,17).isFilled(), equalTo(false));
        assertThat(game.at(0,16).isFilled(), equalTo(false));
        assertThat(game.at(0,15).isFilled(), equalTo(false));
        assertThat(game.at(0,14).isFilled(), equalTo(false));
        assertThat(game.at(0,13).isFilled(), equalTo(false));
        assertThat(game.at(0,12).isFilled(), equalTo(false));
        assertThat(game.at(0,11).isFilled(), equalTo(false));
        assertThat(game.at(0,10).isFilled(), equalTo(false));
        assertThat(game.at(0, 9).isFilled(), equalTo(false));
        assertThat(game.at(0, 8).isFilled(), equalTo(false));
        assertThat(game.at(0, 7).isFilled(), equalTo(false));
        assertThat(game.at(0, 6).isFilled(), equalTo(false));
        assertThat(game.at(0, 5).isFilled(), equalTo(false));
        assertThat(game.at(0, 4).isFilled(), equalTo(false));
        assertThat(game.at(0, 3).isFilled(), equalTo(true));
        assertThat(game.at(0, 2).isFilled(), equalTo(true));
        assertThat(game.at(0, 1).isFilled(), equalTo(true));
        assertThat(game.at(0, 0).isFilled(), equalTo(true));
    }

    @Test
    public void itKeepsTheLogAtTheBottom() {
        Game game = new Game();
        game.start();

        tickNTimes(game, 20);

        // Column 1
        assertThat(game.at(0,17).isFilled(), equalTo(false));
        assertThat(game.at(0,16).isFilled(), equalTo(false));
        assertThat(game.at(0,15).isFilled(), equalTo(false));
        assertThat(game.at(0,14).isFilled(), equalTo(false));
        assertThat(game.at(0,13).isFilled(), equalTo(false));
        assertThat(game.at(0,12).isFilled(), equalTo(false));
        assertThat(game.at(0,11).isFilled(), equalTo(false));
        assertThat(game.at(0,10).isFilled(), equalTo(false));
        assertThat(game.at(0, 9).isFilled(), equalTo(false));
        assertThat(game.at(0, 8).isFilled(), equalTo(false));
        assertThat(game.at(0, 7).isFilled(), equalTo(false));
        assertThat(game.at(0, 6).isFilled(), equalTo(false));
        assertThat(game.at(0, 5).isFilled(), equalTo(false));
        assertThat(game.at(0, 4).isFilled(), equalTo(false));
        assertThat(game.at(0, 3).isFilled(), equalTo(true));
        assertThat(game.at(0, 2).isFilled(), equalTo(true));
        assertThat(game.at(0, 1).isFilled(), equalTo(true));
        assertThat(game.at(0, 0).isFilled(), equalTo(true));
    }

    @Test
    public void itCanStartTheLogAtAnyX() {
        Game game = new Game();
        game.start();
        game.setSpawnPoint(1);

        tickNTimes(game, 20);

        // Column 1
        assertThat(game.at(1,17).isFilled(), equalTo(false));
        assertThat(game.at(1,16).isFilled(), equalTo(false));
        assertThat(game.at(1,15).isFilled(), equalTo(false));
        assertThat(game.at(1,14).isFilled(), equalTo(false));
        assertThat(game.at(1,13).isFilled(), equalTo(false));
        assertThat(game.at(1,12).isFilled(), equalTo(false));
        assertThat(game.at(1,11).isFilled(), equalTo(false));
        assertThat(game.at(1,10).isFilled(), equalTo(false));
        assertThat(game.at(1, 9).isFilled(), equalTo(false));
        assertThat(game.at(1, 8).isFilled(), equalTo(false));
        assertThat(game.at(1, 7).isFilled(), equalTo(false));
        assertThat(game.at(1, 6).isFilled(), equalTo(false));
        assertThat(game.at(1, 5).isFilled(), equalTo(false));
        assertThat(game.at(1, 4).isFilled(), equalTo(false));
        assertThat(game.at(1, 3).isFilled(), equalTo(true));
        assertThat(game.at(1, 2).isFilled(), equalTo(true));
        assertThat(game.at(1, 1).isFilled(), equalTo(true));
        assertThat(game.at(1, 0).isFilled(), equalTo(true));


        assertThat(game.at(0,17).isFilled(), equalTo(false));
        assertThat(game.at(0,16).isFilled(), equalTo(false));
        assertThat(game.at(0,15).isFilled(), equalTo(false));
        assertThat(game.at(0,14).isFilled(), equalTo(false));
        assertThat(game.at(0,13).isFilled(), equalTo(false));
        assertThat(game.at(0,12).isFilled(), equalTo(false));
        assertThat(game.at(0,11).isFilled(), equalTo(false));
        assertThat(game.at(0,10).isFilled(), equalTo(false));
        assertThat(game.at(0, 9).isFilled(), equalTo(false));
        assertThat(game.at(0, 8).isFilled(), equalTo(false));
        assertThat(game.at(0, 7).isFilled(), equalTo(false));
        assertThat(game.at(0, 6).isFilled(), equalTo(false));
        assertThat(game.at(0, 5).isFilled(), equalTo(false));
        assertThat(game.at(0, 4).isFilled(), equalTo(false));
        assertThat(game.at(0, 3).isFilled(), equalTo(false));
        assertThat(game.at(0, 2).isFilled(), equalTo(false));
        assertThat(game.at(0, 1).isFilled(), equalTo(false));
        assertThat(game.at(0, 0).isFilled(), equalTo(false));
    }

    private void tickNTimes(Game game, int i) {
        IntStream.range(0, i).forEach(number -> {
            game.tick();
        });
    }

}