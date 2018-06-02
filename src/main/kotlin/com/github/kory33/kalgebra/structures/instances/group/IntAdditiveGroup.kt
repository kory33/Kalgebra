package com.github.kory33.kalgebra.structures.instances.group

import com.github.kory33.kalgebra.operations.AbelianGroupOperation
import com.github.kory33.kalgebra.structures.AbelianGroup
import com.github.kory33.kalgebra.structures.SumComposable

class IntAdditiveGroup(value: Int): AbelianGroup<Int, IntAdditiveGroup>(value), SumComposable<IntAdditiveGroup> {

    override val operation: AbelianGroupOperation<Int> = IntAdditiveGroup
    override fun lift(value: Int) = IntAdditiveGroup(value)

    companion object: AbelianGroupOperation<Int> {
        override fun invoke(p1: Int, p2: Int): Int = p1 + p2
        override val identity: Int = 0
        override val Int.inverse: Int
            get() = unaryMinus()
    }

}
