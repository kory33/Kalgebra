package com.github.kory33.kalgebra.structures.instances.monoid

import com.github.kory33.kalgebra.MonoidOperation
import com.github.kory33.kalgebra.structures.Monoid

class StringMonoid(value: String): Monoid<String, StringMonoid>(value, StringMonoid) {

    override fun lift(value: String) = StringMonoid(value)

    companion object: MonoidOperation<String> {

        override fun invoke(p1: String, p2: String) = p1 + p2

        override val identity = ""

    }

}
