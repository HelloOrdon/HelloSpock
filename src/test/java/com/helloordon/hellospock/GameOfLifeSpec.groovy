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

    def "Single life should die alone"() {
        given:
        def game = new GameOfLife([[0, 0]])

        when:
        game.tick()

        then:
        !game.isAlive(0, 0)
    }

    def "Group of 4 lives should survive"() {
        given:
        def game = new GameOfLife([[0, 0],[1, 0],[0, 1],[1, 1]])

        when:
        game.tick()

        then:
        game.isAlive(0, 0)
        game.isAlive(1, 0)
        game.isAlive(0, 1)
        game.isAlive(1, 1)
    }
}
