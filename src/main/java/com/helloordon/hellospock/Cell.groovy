package com.helloordon.hellospock

import groovy.transform.CompileStatic
import groovy.transform.Immutable

@CompileStatic
@Immutable
final class Cell {
    int x
    int y

    List<Cell> neighbours() {
        [new Cell(-1, -1), new Cell(-1, 0), new Cell(-1, 1),
         new Cell(0, -1), /*            */ new Cell(0, 1),
         new Cell(1, -1), new Cell(1, 0), new Cell(1, 1)]
    }
}
