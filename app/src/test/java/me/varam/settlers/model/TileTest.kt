package me.varam.settlers.model

import me.varam.settlers.common.exceptions.IllegalNumberTokenException
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

/**
 * @author : daniil.mironov
 * Created : 12.12.2021
 **/
class TileTest {

    @Test
    fun testCreatingLegalTile() {
        Tile(ResourceType.LUMBER, 2)
        Tile(ResourceType.BRICK, 3)
        Tile(ResourceType.WOOL, 4)
        Tile(ResourceType.ORE, 5)
        Tile(ResourceType.GRAIN, 6)
        Tile(ResourceType.GOLD, 8)
        Tile(ResourceType.LUMBER, 9)
        Tile(ResourceType.BRICK, 10)
        Tile(ResourceType.WOOL, 11)
        Tile(ResourceType.GRAIN, 12)
    }

    @Test
    fun testCreatingIllegalTile() {
        assertThrows<IllegalNumberTokenException> { Tile(ResourceType.WOOL, 1) }
        assertThrows<IllegalNumberTokenException> { Tile(ResourceType.WOOL, -20) }
        assertThrows<IllegalNumberTokenException> { Tile(ResourceType.WOOL, 0) }
        assertThrows<IllegalNumberTokenException> { Tile(ResourceType.WOOL, 7) }
        assertThrows<IllegalNumberTokenException> { Tile(ResourceType.WOOL, 13) }
        assertThrows<IllegalNumberTokenException> { Tile(ResourceType.WOOL, 100) }
    }
}
