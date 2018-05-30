package com.github.kory33.kalgebra.structures

import com.github.kory33.kalgebra.CommutativeGroupOperation
import com.github.kory33.kalgebra.GroupOperation
import com.github.kory33.kalgebra.MonoidOperation

abstract class Monoid<E, M: Monoid<E, M>>(value: E, override val operation: MonoidOperation<E>): Magma<E, M>(value)

abstract class Group<E, G: Group<E, G>>(value: E, operation: GroupOperation<E>): Monoid<E, G>(value, operation) {

    protected val inverseValue = operation.run { this@Group.value.inverse }

    abstract val inverse: G

}

abstract class AbelianGroup<E, G: AbelianGroup<E, G>>(value: E, operation: CommutativeGroupOperation<E>)
    : Group<E, G>(value, operation)
