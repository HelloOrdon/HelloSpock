package com.helloordon.hellospock

import groovy.transform.CompileStatic

@CompileStatic
final class TickThread extends Thread {
    private DrawingPanel gui
    private GameOfLife board

    TickThread(DrawingPanel gui, GameOfLife board) {
        this.gui = gui
        this.board = board
    }

    @Override
    void run(){
        while (true){
            board.tick()
            gui.repaint()
            Thread.sleep(400)
        }
    }
}
