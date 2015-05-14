package com.helloordon.hellospock

import groovy.transform.CompileStatic

import javax.swing.*

@CompileStatic
final class Gui extends JFrame {

    Gui(GameOfLife board) {
        super('Game of life')
        visible = true
        add(new DrawingPanel(board))
        setSize(1800,1000)
        setDefaultCloseOperation(EXIT_ON_CLOSE)
    }

}

