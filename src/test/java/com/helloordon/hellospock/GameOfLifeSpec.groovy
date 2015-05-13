package com.helloordon.hellospock

import spock.lang.Specification

final class GameOfLifeSpec extends Specification {

    def "Game should be dead on start"() {
        given:
        def game = new GameOfLife([])

        expect:
        !game.isAlive(0, 0)
    }

    def "Game created with life should be alive only at given position"() {
        given:
        def game = new GameOfLife([[0, 0]])

        expect:
        game.isAlive(x, y) == status

        where:
        x | y | status
        0 | 0 | true
        1 | 1 | false
    }
}
