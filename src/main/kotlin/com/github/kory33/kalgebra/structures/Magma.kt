package com.github.kory33.kalgebra.structures

import com.github.kory33.kalgebra.MagmaOperation

abstract class Magma<E, M: Magma<E, M>>(val value: E) {

    protected abstract val operation: MagmaOperation<E>

    protected infix fun composeValue(another: Magma<E, M>): E = operation(value, another.value)

    abstract infix fun compose(another: Magma<E, M>): M

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
