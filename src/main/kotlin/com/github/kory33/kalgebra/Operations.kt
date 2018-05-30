package com.github.kory33.kalgebra

/**
 * Interface for operations which take two values of type [M] and return a value of type [M].
 *
 * The requirement is that for all `(x1, y1): (M, M)` and `(x2, y2): (M, M)`,
 * if `x1 == x2` and `y1 == y2` then `x1 applyTo y1 == x2 applyTo y2`.
 *
 * This means that the values returned from an operation should be consistent.
 */
interface MagmaOperation<M>: (M, M) -> M {

    /**
     * Applies the operation to the pair of receiver and the given argument.
     */
    infix fun M.applyTo(another: M) = this@MagmaOperation(this@applyTo, another)

}

/**
 * Interface for operations which are commutative.
 * That is, for all `(a, b): (M, M)`, `a applyTo b == b applyTo a`.
 */
interface CommutativeOperation<M>: MagmaOperation<M>

/**
 * Interface for operations which are associative.
 * That is, for all `(a, b, c): (M, M, M)`, `(a applyTo b) applyTo c == a applyTo (b applyTo c)`
 */
interface AssociativeOperation<M>: MagmaOperation<M>

/**
 * Interface for operations which have an identity element `e` that satisfies the following condition:
 *
 * For all `a: M`, `a applyTo e == e applyTo a` and `a applyTo e == a`.
 */
interface IdentityElementOperation<M>: MagmaOperation<M> {

    /**
     * Identity element of the operation
     */
    val identity: M

}

/**
 * Interface for operations which has a property of operation of a monoid.
 */
interface MonoidOperation<M>: AssociativeOperation<M>, IdentityElementOperation<M>

/**
 * Interface for commutative monoid operations.
 */
interface CommutativeMonoidOperation<M>: MonoidOperation<M>, CommutativeOperation<M>

/**
 * Interface for operations which has a property of operation of a group.
 *
 * That is, for all `a: M`, there exists an inverse `b: M` which satisfies
 * `a applyTo b == b applyTo a` and `a applyTo b == e`, where `e: M` is an identity element in the monoid.
 */
interface GroupOperation<M>: MonoidOperation<M> {

    /**
     * Extension property on [M] which gives an inverse on this operation
     */
    val M.inverse: M

}

/**
 * Interface for commutative group operations.
 */
interface CommutativeGroupOperation<M>: GroupOperation<M>, CommutativeMonoidOperation<M>

/**
 * Interface for operations on additive group of [M].
 *
 * [plus] extension function should be consistent with [invoke].
 * By default, [invoke] uses outcome of [plus] and there is no need to override it.
 */
interface AdditiveGroupOperation<M>: CommutativeGroupOperation<M> {

    operator fun M.plus(another: M): M

    override fun invoke(p1: M, p2: M): M = p1 + p2

}

/**
 * Interface for operations on multiplicative group of [M].
 *
 * [times] extension function should be consistent with [invoke].
 * By default, [invoke] uses outcome of [times] and there is no need to override it.
 */
interface MultiplicativeGroupOperation<M>: CommutativeGroupOperation<M> {

    operator fun M.times(another: M): M

    override fun invoke(p1: M, p2: M): M = p1 * p2

}
