package com.github.kory33.kalgebra.structures

import com.github.kory33.kalgebra.operations.CommutativeGroupOperation
import com.github.kory33.kalgebra.operations.GroupOperation
import com.github.kory33.kalgebra.operations.MonoidOperation

/**
 * Class of monoid structures.
 */
abstract class Monoid<E, M: Monoid<E, M>>(value: E): Magma<E, M>(value) {

    abstract override val operation: MonoidOperation<E>

}

/**
 * Class of group structures.
 */
abstract class Group<E, G: Group<E, G>>(value: E)
    : Monoid<E, G>(value) {

    abstract override val operation: GroupOperation<E>

    /**
     * Inverse of this object.
     *
     * If this object is composed with this inverse,
     * the resulting object will equal to identity element in monoid.
     */
    val inverse: G by lazy {
        lift(with(operation) { this@Group.value.inverse })
    }

}

/**
 * Class of abelian(commutative) group structures.
 */
abstract class AbelianGroup<E, G: AbelianGroup<E, G>>(value: E) : Group<E, G>(value) {

    abstract override val operation: CommutativeGroupOperation<E>

}
