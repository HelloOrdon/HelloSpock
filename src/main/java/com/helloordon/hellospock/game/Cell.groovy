package com.helloordon.hellospock.game

import groovy.transform.CompileStatic
import groovy.transform.Immutable

@CompileStatic
@Immutable
final class Cell {
    int x
    int y

    List<Cell> neighbours() {
        [new Cell(x - 1, y - 1), new Cell(x - 1, y), new Cell(x - 1, y + 1),
         new Cell(x + 0, y - 1), /*               */ new Cell(x + 0, y + 1),
         new Cell(x + 1, y - 1), new Cell(x + 1, y), new Cell(x + 1, y + 1)]
    }
}
