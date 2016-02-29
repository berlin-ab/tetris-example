package com.berlinab.tetris;

public class Game {
    private Boolean started;
    private Board board;

    int position;
    int spawnPoint;

    public Game() {
        started = false;
        board = new Board();

        position = board.rowCount() - 1;
        spawnPoint = 0;
    }

    public void setSpawnPoint(Integer x) {
        spawnPoint = x;
    }

    public void start() {
        started = true;
    }

    public Boolean started() {
        return started;
    }

    public void pause() {
        started = false;
    }

    public Board board() {
        return board;
    }

    public void tick() {
        if(position >= 0) {
            int nextPosition = position--;
            board.at(spawnPoint, nextPosition+4).unfill();
            board.at(spawnPoint, nextPosition).fill();
        }
    }

    public Cell at(Integer x, Integer y) {
        return board.at(x, y);
    }
}
