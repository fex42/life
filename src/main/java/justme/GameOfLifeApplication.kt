package justme

import java.awt.EventQueue
import javax.swing.JFrame

class GameOfLifeApplication : JFrame() {
    private val glider = Board(20, 20,
            hashSetOf(Pos(4, 4), Pos(5, 5), Pos(6, 5), Pos(6, 4), Pos(6, 3)))

    init {
        add(BoardPanel(glider))

        setSize(300, 337)

        title = "Game of Life"
        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
    }
}

fun main(args: Array<String>) = EventQueue.invokeLater {
    val ex = GameOfLifeApplication()
    ex.isVisible = true
}