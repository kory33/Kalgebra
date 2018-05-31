package com.github.kory33.kalgebra.structures.instances.monoid

import com.github.kory33.kalgebra.operations.MonoidOperation
import com.github.kory33.kalgebra.structures.Monoid

class IntMultiplicativeMonoid(value: Int): Monoid<Int, IntMultiplicativeMonoid>(value) {

    override val operation: MonoidOperation<Int> = IntMultiplicativeMonoid
    override fun lift(value: Int): IntMultiplicativeMonoid = IntMultiplicativeMonoid(value)

    companion object: MonoidOperation<Int> {
        override fun invoke(p1: Int, p2: Int): Int = p1 * p2
        override val identity = 1
    }

}