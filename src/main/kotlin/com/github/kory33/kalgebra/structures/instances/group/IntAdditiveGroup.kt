package com.github.kory33.kalgebra.structures.instances.group

import com.github.kory33.kalgebra.operations.CommutativeGroupOperation
import com.github.kory33.kalgebra.structures.AbelianGroup

class IntAdditiveGroup(value: Int): AbelianGroup<Int, IntAdditiveGroup>(value) {

    override val operation: CommutativeGroupOperation<Int> = IntAdditiveGroup
    override fun lift(value: Int) = IntAdditiveGroup(value)

    companion object: CommutativeGroupOperation<Int> {
        override fun invoke(p1: Int, p2: Int): Int = p1 + p2
        override val identity: Int = 0
        override val Int.inverse: Int
            get() = unaryMinus()
    }

}
