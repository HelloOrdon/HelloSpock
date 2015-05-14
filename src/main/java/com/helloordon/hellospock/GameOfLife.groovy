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
        lives = (survived() + emerged()).unique()
    }

    List<Cell> survived() {
        lives.findAll { shouldSurvive(it) }
    }

    boolean shouldSurvive(Cell life) {
        return livingNeighboursCount(life) in [2, 3]
    }

    List<Cell> emerged() {
        lives.collectMany { it.neighbours() }
                .findAll { !isAlive(it) }
                .findAll { shouldEmerge(it) }
    }

    boolean shouldEmerge(Cell life) {
        return livingNeighboursCount(life) == 3
    }

    int livingNeighboursCount(Cell life) {
        return life.neighbours().findAll { isAlive(it) }.size()
    }
}
