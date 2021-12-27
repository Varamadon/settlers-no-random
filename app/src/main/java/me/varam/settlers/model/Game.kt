package me.varam.settlers.model

/**
 * @author : daniil.mironov
 * Created : 13.12.2021
 **/
class Game(
    private val playerColorsByPlayer: Map<Player, PlayerColor>
) {

    public fun getPlayersIncomeByColor(resourceGainMultiplier: Double): Map<PlayerColor, Map<ResourceType, Int>> {
        return playerColorsByPlayer.entries.associateBy({it.value}) {it.key.getIncome(resourceGainMultiplier)}
    }
}
