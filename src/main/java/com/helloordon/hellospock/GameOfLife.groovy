package com.helloordon.hellospock

import groovy.transform.CompileStatic

@CompileStatic
final class GameOfLife {
    private List<Cell> lives

    GameOfLife(List<List<Integer>> lives) {
        this.lives = lives.collect { new Cell(it[0], it[1]) }
    }

    boolean isAlive(int x, int y) {
        def cell = new Cell(x, y)
        return isAlive(cell)
    }

    boolean isAlive(Cell cell) {
        return lives.contains(cell)
    }

    void tick() {
        lives = lives.findAll { shouldSurvive(it) }
    }

    boolean shouldSurvive(Cell life) {
        life.neighbours().findAll{ isAlive(it) }
    }
}
