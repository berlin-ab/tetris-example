package com.berlinab.tetrisui;

import com.berlinab.tetris.Game;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class GuiTest {

    @Test
    public void itShouldDrawTheInitialGameBoard() {
        Game game = new Game();

        Gui gui = new Gui(game);

        List<String> rows = gui.draw();

        assertThat(rows.get(0),  equalTo("------------"));
        assertThat(rows.get(1),  equalTo("|          |"));
        assertThat(rows.get(2),  equalTo("|          |"));
        assertThat(rows.get(3),  equalTo("|          |"));
        assertThat(rows.get(4),  equalTo("|          |"));
        assertThat(rows.get(5),  equalTo("|          |"));
        assertThat(rows.get(6),  equalTo("|          |"));
        assertThat(rows.get(7),  equalTo("|          |"));
        assertThat(rows.get(8),  equalTo("|          |"));
        assertThat(rows.get(9),  equalTo("|          |"));
        assertThat(rows.get(10), equalTo("|          |"));
        assertThat(rows.get(11), equalTo("|          |"));
        assertThat(rows.get(12), equalTo("|          |"));
        assertThat(rows.get(13), equalTo("|          |"));
        assertThat(rows.get(14), equalTo("|          |"));
        assertThat(rows.get(15), equalTo("|          |"));
        assertThat(rows.get(16), equalTo("|          |"));
        assertThat(rows.get(17), equalTo("|          |"));
        assertThat(rows.get(18), equalTo("|          |"));
        assertThat(rows.get(19), equalTo("------------"));
    }

    @Test
    public void itShouldDrawTheGameBoardFiveTicksIn() {
        Game game = new Game();

        Gui gui = new Gui(game);

        game.tick();
        game.tick();
        game.tick();
        game.tick();
        game.tick();

        List<String> rows = gui.draw();

        assertThat(rows.get(0),  equalTo("------------"));
        assertThat(rows.get(1),  equalTo("|          |"));
        assertThat(rows.get(2),  equalTo("|x         |"));
        assertThat(rows.get(3),  equalTo("|x         |"));
        assertThat(rows.get(4),  equalTo("|x         |"));
        assertThat(rows.get(5),  equalTo("|x         |"));
        assertThat(rows.get(6),  equalTo("|          |"));
        assertThat(rows.get(7),  equalTo("|          |"));
        assertThat(rows.get(8),  equalTo("|          |"));
        assertThat(rows.get(9),  equalTo("|          |"));
        assertThat(rows.get(10), equalTo("|          |"));
        assertThat(rows.get(11), equalTo("|          |"));
        assertThat(rows.get(12), equalTo("|          |"));
        assertThat(rows.get(13), equalTo("|          |"));
        assertThat(rows.get(14), equalTo("|          |"));
        assertThat(rows.get(15), equalTo("|          |"));
        assertThat(rows.get(16), equalTo("|          |"));
        assertThat(rows.get(17), equalTo("|          |"));
        assertThat(rows.get(18), equalTo("|          |"));
        assertThat(rows.get(19), equalTo("------------"));
    }

}