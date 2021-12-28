package me.varam.settlers.model

import kotlin.math.abs

/**
 * @author : daniil.mironov
 * Created : 11.12.2021
 **/
class Player(val color: PlayerColor) {
    private val tiles: MutableList<Tile> = mutableListOf()
    private val accumulatedResources: MutableMap<ResourceType, Double> = mutableMapOf(
        Pair(ResourceType.LUMBER, 0.0),
        Pair(ResourceType.BRICK, 0.0),
        Pair(ResourceType.WOOL, 0.0),
        Pair(ResourceType.ORE, 0.0),
        Pair(ResourceType.GRAIN, 0.0),
        Pair(ResourceType.GOLD, 0.0)
    )

    public fun addTile(tile: Tile) {
        tiles.add(tile)
    }

    public fun getIncome(resourceGainMultiplier: Double): Map<ResourceType, Int> {
        for (tile in tiles) {
            val afterIncome =
                accumulatedResources[tile.resourceType]!! + getIncomeFromTile(tile) * resourceGainMultiplier
            accumulatedResources[tile.resourceType] = afterIncome
        }
        val result = mutableMapOf<ResourceType, Int>()
        for (resource in accumulatedResources.keys) {
            result[resource] = getIncomeByResource(resource)
        }
        return result.toMap()
    }

    private fun getIncomeFromTile(tile: Tile): Double {
        return (6 - abs(7 - tile.numberToken)) / 36.0
    }

    private fun getIncomeByResource(resource: ResourceType): Int {
        val amount = accumulatedResources[resource]!!
        var intAmount = amount.toInt()
        if (amount - intAmount > 0.999) intAmount++
        if (amount - intAmount < 0) {
            accumulatedResources[resource] = 0.0
        } else {
            accumulatedResources[resource] = amount - intAmount
        }
        return intAmount
    }

}
