package com.github.kory33.kalgebra.structures

interface Composable<T> {

    infix fun compose(another: T): T

}

interface Additive<T> {

    operator fun plus(another: T): T

}

interface Multiplicative<T> {

    operator fun times(another: T): T

}

interface SumComposable<T>: Composable<T>, Additive<T> {

    override operator fun plus(another: T) = compose(another)

}

interface ProductComposable<T>: Composable<T>, Multiplicative<T> {

    override operator fun times(another: T) = compose(another)

}
