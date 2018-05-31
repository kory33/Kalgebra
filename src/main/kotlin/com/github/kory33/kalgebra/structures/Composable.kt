package com.github.kory33.kalgebra.structures

interface Composable<T, R> {

    infix fun compose(another: T): R

}

interface Multiplicative<T, R>: Composable<T, R> {

    operator fun times(another: T) = compose(another)

}

interface Additive<T, R>: Composable<T, R> {

    operator fun plus(another: T) = compose(another)

}
