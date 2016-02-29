package com.berlinab.tetris;

public class Cell {
    private boolean filled = false;

    public boolean isFilled() {
        return filled;
    }

    public void fill() {
        filled = true;
    }

    public void unfill() {
        filled = false;
    }
}
