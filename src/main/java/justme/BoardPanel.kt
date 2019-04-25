package justme

import javax.swing.*
import java.awt.*
import java.awt.event.ActionEvent
import java.awt.event.ActionListener

class BoardPanel(var board: Board) : JPanel(), ActionListener {

    init {
        Timer(250, this).start()
    }

    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)
        drawBoard(g)
    }

    private fun drawBoard(g: Graphics) {
        val cellWidth = (size.getWidth() / board.width).toInt()
        val cellHeight = (size.getHeight() / board.height).toInt()

        board.cells.forEach { (x, y) -> g.fillOval(x * cellWidth, y * cellHeight, cellWidth, cellHeight) }
    }

    override fun actionPerformed(e: ActionEvent) {
        board = board.nextGen()
        repaint()
    }
}