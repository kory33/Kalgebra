package com.github.kory33.kalgebra.structures

import com.github.kory33.kalgebra.MagmaOperation

/**
 * Class of magma structures.
 */
abstract class Magma<E, M: Magma<E, M>>(val value: E) {

    /**
     * an operation associated with this magma
     */
    abstract val operation: MagmaOperation<E>

    /**
     * A function that 'lifts' a given value to a magma.
     *
     * The returned magma object must have [Magma.value] equal to the given [value].
     */
    protected abstract fun lift(value: E): M

    /**
     * compose another magma using the associated operation
     */
    infix fun compose(another: Magma<E, M>): M = lift(operation(value, another.value))

    override fun toString() = "${javaClass.name}[value = $value]"

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Magma<*, *>

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value?.hashCode() ?: 0
    }

}
