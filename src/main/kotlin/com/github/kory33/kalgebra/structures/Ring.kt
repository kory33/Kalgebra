package com.github.kory33.kalgebra.structures

import com.github.kory33.kalgebra.operations.AbelianGroupOperation
import com.github.kory33.kalgebra.operations.MonoidOperation

/**
 * Class of ring structures.
 *
 * Implementation of this class should satisfy distributive law. i.e.
 * `a ∗ (b + c) = (a ∗ b) + (a ∗ c)` and `(a + b) ∗ c = (a ∗ c) + (b ∗ c)` for all `a`, `b`, `c`.
 */
abstract class Ring<E, R: Ring<E, R>>(val value: E): Additive<R>, Multiplicative<R> {

    /**
     * commutative group operation as addition
     */
    abstract val plusOperation: AbelianGroupOperation<E>

    /**
     * monoid operation as multiplication
     */
    abstract val multOperation: MonoidOperation<E>

    /**
     * A function that 'lifts' a given value to a magma.
     *
     * The returned ring object must have [Ring.value] equal to the given [value].
     */
    protected abstract fun lift(value: E): R

    override fun plus(another: R): R = lift(plusOperation(value, another.value))

    override fun times(another: R): R = lift(multOperation(value, another.value))

    override fun toString() = "${javaClass.name}[value = $value]"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Ring<*, *>

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }

}