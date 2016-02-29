package com.berlinab.tetrisui;

import com.berlinab.tetris.Cell;
import com.berlinab.tetris.Game;

import java.util.ArrayList;
import java.util.List;

public class Gui {
    private final Game game;
    private final List<String> rows;

    public Gui(Game game) {
        this.game = game;
        this.rows = new ArrayList<>();
    }

    public List<String> draw() {
        this.rows.add("------------");

        this.game.board().rows().stream().forEach(row -> {
            String rowString = "|";

            for(Cell cell : row) {
                if(cell.isFilled()) {
                    rowString = rowString + "x";
                } else {
                    rowString = rowString + " ";
                }
            }

            rowString = rowString + "|";

            this.rows.add(rowString);
        });

        this.rows.add("------------");

        System.out.println(rows);

        return rows;
    }
}
