package com.helloordon.hellospock

import groovy.transform.CompileStatic

@CompileStatic
final class GameOfLife {
    private List<List<Integer>> lives

    GameOfLife(List<List<Integer>> lives) {
        this.lives = lives
    }

    boolean isAlive(int x, int y) {
        return lives.contains([x, y])
    }

    void tick() {
        lives.clear()
    }
}
