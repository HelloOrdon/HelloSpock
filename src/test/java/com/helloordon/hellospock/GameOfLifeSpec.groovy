package com.helloordon.hellospock

import spock.lang.Specification

final class GameOfLifeSpec extends Specification {
    def "Should create game"() {
        expect:
        new GameOfLife()
    }

    def "Game should be dead on start"() {
        given:
        def game = new GameOfLife()
        expect:
        game.isAlive(0, 0) == false
    }
}
