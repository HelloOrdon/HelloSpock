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
        lives = lives.findAll { shouldSurvive(it) }
        if (lives.size() < 4)
            lives.clear()
    }

    boolean shouldSurvive(List<Integer> life) {
        life[0] < 3
    }
}
