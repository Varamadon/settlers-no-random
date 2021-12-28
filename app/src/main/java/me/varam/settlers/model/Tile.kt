package me.varam.settlers.model

import me.varam.settlers.common.exceptions.IllegalNumberTokenException
import me.varam.settlers.common.validTokenNumbers
import me.varam.settlers.model.ResourceType

/**
 * @author : daniil.mironov
 * Created : 11.12.2021
 **/
data class Tile (val resourceType: ResourceType, val numberToken: Int) {
    init {
        if (!validTokenNumbers.contains(numberToken)) {
            throw IllegalNumberTokenException()
        }
    }
}
