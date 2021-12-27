package me.varam.settlers.model

import me.varam.settlers.common.exceptions.IllegalNumberTokenException
import me.varam.settlers.model.ResourceType

/**
 * @author : daniil.mironov
 * Created : 11.12.2021
 **/
data class Tile (val resourceType: ResourceType, val numberToken: Int) {
    init {
        if (numberToken == 7 || numberToken < 2 || numberToken > 12) {
            throw IllegalNumberTokenException()
        }
    }
}
