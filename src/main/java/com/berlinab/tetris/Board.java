package com.berlinab.tetris;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class Board {

    private final int width = 10;
    private final int height = 18;
    private List<Row> rows = new LinkedList<>();

    public Board() {
        IntStream.range(0, rowCount()).forEach(rowNumber -> {
            Row row = new Row();
            rows.add(row);

            IntStream.range(0, columnCount()).forEach(columnNumber -> {
                row.add(new Cell());
            });
        });
    }

    public Cell at(Integer x, Integer y) {
        Integer realY = height - y - 1;

        try {
            return rows.get(realY).get(x);
        } catch (IndexOutOfBoundsException exception) {
            return new Cell();
        }
    }

    public List<Row> rows() {
        return rows;
    }

    public Integer columnCount() {
        return width;
    }

    public Integer rowCount() {
        return height;
    }
}
