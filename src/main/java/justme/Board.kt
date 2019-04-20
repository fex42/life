package justme

data class Board(val width: Int, val height: Int, val cells: Set<Pos>)
{
    private fun isAlive(cell: Pos): Boolean = cells.contains(cell)

    private fun isEmpty(cell: Pos): Boolean = !cells.contains(cell)

    private fun liveNeighbours(cell: Pos): Int = cell.neighbours(width, height).filter { isAlive(it) }.size

    private fun survivors(): Set<Pos> = cells.filter { liveNeighbours(it) in 2..3 }.toSet()

    private fun births(): Set<Pos> = cells.flatMap { c -> c.neighbours(width, height) }.filter { isEmpty(it) }.filter { liveNeighbours(it) == 3}.toSet()

    fun nextGen(): Board = Board(width, height, births().plus(survivors()))
}
