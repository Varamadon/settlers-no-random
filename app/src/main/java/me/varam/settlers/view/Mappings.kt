package me.varam.settlers.view

import android.graphics.Color
import me.varam.settlers.R
import me.varam.settlers.model.PlayerColor

val playerColorMap = mapOf(
    Pair(PlayerColor.RED, Color.RED),
    Pair(PlayerColor.WHITE, Color.LTGRAY),
    Pair(PlayerColor.BROWN, Color.rgb(139,69,19)),
    Pair(PlayerColor.BLUE, Color.BLUE),
    Pair(PlayerColor.YELLOW, Color.YELLOW),
    Pair(PlayerColor.ORANGE, Color.rgb(255, 165, 0)),
    Pair(PlayerColor.BLACK, Color.BLACK),
    Pair(PlayerColor.GREEN, Color.GREEN)
)

val playerNameMap = mapOf(
    Pair(PlayerColor.RED, R.string.red_player),
    Pair(PlayerColor.WHITE, R.string.white_player),
    Pair(PlayerColor.BROWN, R.string.brown_player),
    Pair(PlayerColor.BLUE, R.string.blue_player),
    Pair(PlayerColor.YELLOW, R.string.yellow_player),
    Pair(PlayerColor.ORANGE, R.string.orange_player),
    Pair(PlayerColor.BLACK, R.string.black_player),
    Pair(PlayerColor.GREEN, R.string.green_player)
)