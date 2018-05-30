package com.github.kory33.kalgebra.structures

import com.github.kory33.kalgebra.CommutativeGroupOperation
import com.github.kory33.kalgebra.GroupOperation
import com.github.kory33.kalgebra.MonoidOperation

/**
 * Class of monoid structures.
 */
abstract class Monoid<E, M: Monoid<E, M>>(value: E, override val operation: MonoidOperation<E>): Magma<E, M>(value)

/**
 * Class of group structures.
 */
abstract class Group<E, G: Group<E, G>>(value: E, operation: GroupOperation<E>): Monoid<E, G>(value, operation) {

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
abstract class AbelianGroup<E, G: AbelianGroup<E, G>>(value: E, operation: CommutativeGroupOperation<E>)
    : Group<E, G>(value, operation)
