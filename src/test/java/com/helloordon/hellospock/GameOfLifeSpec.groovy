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
        def game = new GameOfLife([[0, 0], [1, 0], [0, 1], [1, 1]])

        when:
        game.tick()

        then:
        game.isAlive(0, 0)
        game.isAlive(1, 0)
        game.isAlive(0, 1)
        game.isAlive(1, 1)
    }

    def "4 lives but not in group should die"() {
        given:
        def game = new GameOfLife([[0, 0], [3, 3], [6, 6], [9, 9]])

        when:
        game.tick()

        then:
        !game.isAlive(0, 0)
        !game.isAlive(3, 3)
        !game.isAlive(6, 6)
        !game.isAlive(9, 9)
    }

    def "Cell should know its neighbours"() {
        given:
        def cell = new Cell(0, 0)

        when:
        def neighbours = cell.neighbours()

        then:
        neighbours == [new Cell(-1, -1), new Cell(-1, 0), new Cell(-1, 1),
                       new Cell(0, -1), /*            */ new Cell(0, 1),
                       new Cell(1, -1), new Cell(1, 0), new Cell(1, 1)]
    }

    def "Cell should know its neighbours also at other position"() {
        given:
        def cell = new Cell(5, 8)

        when:
        def neighbours = cell.neighbours()

        then:
        neighbours == [new Cell(4, 7), new Cell(4, 8), new Cell(4, 9),
                       new Cell(5, 7), /*           */ new Cell(5, 9),
                       new Cell(6, 7), new Cell(6, 8), new Cell(6, 9)]
    }

//    def "Group of 4 lives should survive at any place"() {
//        given:
//        def game = new GameOfLife([[3, 3],[4, 3],[3, 4],[4, 4]])
//
//        when:
//        game.tick()
//
//        then:
//        game.isAlive(3, 3)
//        game.isAlive(4, 3)
//        game.isAlive(3, 4)
//        game.isAlive(4, 4)
//    }
}
