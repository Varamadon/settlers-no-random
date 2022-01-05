package me.varam.settlers.model

/**
 * @author : daniil.mironov
 * Created : 13.12.2021
 **/
object Game {

    private val playersByColor: MutableMap<PlayerColor, Player> = mutableMapOf()
    public var isStarted = false
        private set

    public fun startGame() {
        isStarted = true
    }

    public fun getPlayerColors(): List<PlayerColor> {
        return playersByColor.keys.toList()
    }

    public fun addPlayer(player: Player) {
        playersByColor[player.color] = player
    }

    public fun getPlayerByColor(playerColor: PlayerColor): Player {
        return playersByColor[playerColor]!!
    }

    public fun getPlayersIncomeByColor(resourceGainMultiplier: Double): Map<PlayerColor, Map<ResourceType, Int>> {
        return playersByColor.values.associateBy({ it.color }) { it.getIncome(resourceGainMultiplier) }
    }
}
