package me.varam.settlers.model

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * @author : daniil.mironov
 * Created : 12.12.2021
 */
internal class PlayerTest {

    @Test
    fun testEarnWithToken6For8Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 6))
        var earned = 0
        for (i in 1..8) {
            val income = player.getIncome(1.0)
            earned += income[ResourceType.LUMBER]!!
        }
        assertEquals(1, earned)
    }

    @Test
    fun testEarnWithToken6For7Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 6))
        var earned = 0
        for (i in 1..7) {
            val income = player.getIncome(1.0)
            earned += income[ResourceType.LUMBER]!!
        }
        assertEquals(0, earned)
    }

    @Test
    fun testEarnFor36Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 6))
        player.addTile(Tile(ResourceType.BRICK, 5))
        player.addTile(Tile(ResourceType.WOOL, 4))
        player.addTile(Tile(ResourceType.ORE, 3))
        player.addTile(Tile(ResourceType.GRAIN, 2))
        player.addTile(Tile(ResourceType.GOLD, 3))
        var earnedLumber = 0
        var earnedBrick = 0
        var earnedWool = 0
        var earnedOre = 0
        var earnedGrain = 0
        var earnedGold = 0
        for (i in 1..36) {
            val income = player.getIncome(1.0)
            earnedLumber += income[ResourceType.LUMBER]!!
            earnedBrick += income[ResourceType.BRICK]!!
            earnedWool += income[ResourceType.WOOL]!!
            earnedOre += income[ResourceType.ORE]!!
            earnedGrain += income[ResourceType.GRAIN]!!
            earnedGold += income[ResourceType.GOLD]!!
        }
        assertEquals(5, earnedLumber)
        assertEquals(4, earnedBrick)
        assertEquals(3, earnedWool)
        assertEquals(2, earnedOre)
        assertEquals(1, earnedGrain)
        assertEquals(2, earnedGold)
    }

    @Test
    fun testEarnDoubleFor36Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 6))
        player.addTile(Tile(ResourceType.BRICK, 5))
        player.addTile(Tile(ResourceType.WOOL, 4))
        player.addTile(Tile(ResourceType.ORE, 3))
        player.addTile(Tile(ResourceType.GRAIN, 2))
        player.addTile(Tile(ResourceType.GOLD, 3))
        player.addTile(Tile(ResourceType.LUMBER, 8))
        player.addTile(Tile(ResourceType.BRICK, 9))
        player.addTile(Tile(ResourceType.WOOL, 10))
        player.addTile(Tile(ResourceType.ORE, 11))
        player.addTile(Tile(ResourceType.GRAIN, 12))
        player.addTile(Tile(ResourceType.GOLD, 11))
        var earnedLumber = 0
        var earnedBrick = 0
        var earnedWool = 0
        var earnedOre = 0
        var earnedGrain = 0
        var earnedGold = 0
        for (i in 1..36) {
            val income = player.getIncome(1.0)
            earnedLumber += income[ResourceType.LUMBER]!!
            earnedBrick += income[ResourceType.BRICK]!!
            earnedWool += income[ResourceType.WOOL]!!
            earnedOre += income[ResourceType.ORE]!!
            earnedGrain += income[ResourceType.GRAIN]!!
            earnedGold += income[ResourceType.GOLD]!!
        }
        assertEquals(10, earnedLumber)
        assertEquals(8, earnedBrick)
        assertEquals(6, earnedWool)
        assertEquals(4, earnedOre)
        assertEquals(2, earnedGrain)
        assertEquals(4, earnedGold)
    }

    @Test
    fun testEarnWithToken5For9Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 5))
        var earned = 0
        for (i in 1..9) {
            val income = player.getIncome(1.0)
            earned += income[ResourceType.LUMBER]!!
        }
        assertEquals(1, earned)
    }

    @Test
    fun testEarnWithToken5For9000Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 5))
        var earned = 0
        for (i in 1..9000) {
            val income = player.getIncome(1.0)
            earned += income[ResourceType.LUMBER]!!
        }
        assertEquals(1000, earned)
    }

    @Test
    fun testEarnWithToken11For18000Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 11))
        var earned = 0
        for (i in 1..18000) {
            val income = player.getIncome(1.0)
            earned += income[ResourceType.LUMBER]!!
        }
        assertEquals(1000, earned)
    }

    @Test
    fun testEarnWithToken2For36000Turns() {
        val player = Player()
        player.addTile(Tile(ResourceType.LUMBER, 2))
        var earned = 0
        for (i in 1..36000) {
            val income = player.getIncome(1.0)
            earned += income[ResourceType.LUMBER]!!
        }
        assertEquals(1000, earned)
    }
}
