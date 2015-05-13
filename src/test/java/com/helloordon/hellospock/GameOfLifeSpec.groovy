package com.helloordon.hellospock

import spock.lang.Specification

final class GameOfLifeSpec extends Specification {
    def "Should create game"() {
        expect:
        new GameOfLife()
    }
}
