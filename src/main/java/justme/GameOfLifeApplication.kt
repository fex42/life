package justme

import java.awt.EventQueue
import javax.swing.JFrame

class GameOfLifeApplication : JFrame() {
    init {
        add(BoardPanel(GLIDER))

        setSize(300, 337)

        title = "Game of Life"
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
    }

    companion object {
        private val GLIDER = Board(20,20, hashSetOf(Pos(4, 4), Pos(5, 5), Pos(6, 5), Pos(6, 4), Pos(6, 3)))

        @JvmStatic
        fun main(args: Array<String>) {
            EventQueue.invokeLater {
                val ex = GameOfLifeApplication()
                ex.isVisible = true
            }
        }
    }
}