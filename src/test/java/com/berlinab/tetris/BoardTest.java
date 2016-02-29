package com.berlinab.tetris;

import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void itStartsWithTenColumns() throws Exception {
        Board board = new Board();
        assertThat(board.columnCount(), equalTo(10));
    }

    @Test
    public void itStartsWithEighteenRows() throws Exception {
        Board board = new Board();
        assertThat(board.rowCount(), equalTo(18));
    }
}