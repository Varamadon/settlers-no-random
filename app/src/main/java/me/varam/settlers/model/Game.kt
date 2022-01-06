package me.varam.settlers.model

/**
 * @author : daniil.mironov
 * Created : 13.12.2021
 **/
object Game {

    private val playersByColor: MutableMap<PlayerColor, Player> = mutableMapOf()
    var isStarted = false
        private set

    fun startGame() {
        isStarted = true
    }

    fun getPlayerColors(): List<PlayerColor> {
        return playersByColor.keys.toList()
    }

    fun addPlayer(player: Player) {
        playersByColor[player.color] = player
    }

    fun getPlayerByColor(playerColor: PlayerColor): Player {
        return playersByColor[playerColor]!!
    }

    fun removePlayerByColor(playerColor: PlayerColor) {
        if (isStarted) throw GameStartedException("Can not remove player mid game!")
        playersByColor.remove(playerColor)
    }

    fun getPlayersIncomeByColor(resourceGainMultiplier: Double): Map<PlayerColor, Map<ResourceType, Int>> {
        return playersByColor.values.associateBy({ it.color }) { it.getIncome(resourceGainMultiplier) }
    }
}

class GameStartedException(message: String) : RuntimeException(message)
