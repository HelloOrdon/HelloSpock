package com.helloordon.hellospock

import javax.swing.*
import java.awt.*
import java.util.List

final class DrawingPanel extends JPanel {
    private static final int side = 50
    GameOfLife board

    DrawingPanel(GameOfLife board) {
        this.board = board
        setBackground(Color.WHITE)
        new Thread({
            while (true){
                board.tick()
                repaint()
                Thread.sleep(1000)
            }
        }).start()
    }

    @Override
    void paint(Graphics graphics) {
        super.paint(graphics)
        graphics.clearRect(0, 0, width, height)
        paintGameOfLife(graphics, board.lives)
    }

    void paintGameOfLife(Graphics graphics, List<Cell> cells) {
        cells.each {
            graphics.fillRect(it.x * side, it.y * side, side, side)
        }
    }
}
