package justme

data class Pos(val x: Int = 0, val y: Int = 0) {
    fun neighbours(boardWidth: Int, boardHeight: Int): Set<Pos> =
            hashSetOf(Pos(x - 1, y - 1), Pos(x - 1, y), Pos(x - 1, y + 1), Pos(x, y + 1),
                    Pos(x + 1, y + 1), Pos(x + 1, y), Pos(x + 1, y - 1), Pos(x, y - 1))
                    .map {
                        if (it.x in 0 until boardWidth && it.y in 0 until boardHeight)
                            it
                        else
                            Pos(it.x fmod boardWidth, it.y fmod boardHeight)
                    }.toSet()

    private infix fun Int.fmod(m: Int): Int = ((this % m) + m) % m
}
