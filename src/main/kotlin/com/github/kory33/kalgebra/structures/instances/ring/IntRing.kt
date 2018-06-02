package com.github.kory33.kalgebra.structures.instances.ring

import com.github.kory33.kalgebra.structures.Ring
import com.github.kory33.kalgebra.structures.instances.group.IntAdditiveGroup
import com.github.kory33.kalgebra.structures.instances.monoid.IntMultiplicativeMonoid

class IntRing(value: Int): Ring<Int, IntRing>(value) {

    override val plusOperation = IntAdditiveGroup

    override val multOperation = IntMultiplicativeMonoid

    override fun lift(value: Int): IntRing = IntRing(value)

}
