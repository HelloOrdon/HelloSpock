package com.helloordon.hellospock

import groovy.transform.CompileStatic

@CompileStatic
final class Main {
    private static Random random = new Random()

    public static void main(String[] args) {
        new Gui(new GameOfLife(randomLives()))
    }

    private static List<List<Integer>> randomLives() {
        return (0..1000).collect {
            [random.nextInt(18*5), random.nextInt(10*5)] as List<Integer>
        }
    }

}
