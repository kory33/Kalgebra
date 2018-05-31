package com.github.kory33.kalgebra.structures.instances.group

import com.github.kory33.kalgebra.GroupOperation
import com.github.kory33.kalgebra.structures.Group

private class ZippedGroupOperations<A, B>(private val op1: GroupOperation<A>, private val op2: GroupOperation<B>)
    : GroupOperation<Pair<A, B>> {

    constructor(ops: Pair<GroupOperation<A>, GroupOperation<B>>): this(ops.first, ops.second)

    override fun invoke(p1: Pair<A, B>, p2: Pair<A, B>): Pair<A, B> =
            Pair(op1(p1.first, p2.first), op2(p1.second, p2.second))

    override val identity: Pair<A, B> = Pair(op1.identity, op2.identity)

    override val Pair<A, B>.inverse: Pair<A, B>
        get() = Pair(
                op1.run { this@inverse.first.inverse },
                op2.run { this@inverse.second.inverse }
        )

}

abstract class GroupProduct<E1, E2, G: GroupProduct<E1, E2, G>>(
        values: Pair<E1, E2>,
        ops: Pair<GroupOperation<E1>, GroupOperation<E2>>
) : Group<Pair<E1, E2>, GroupProduct<E1, E2, G>>(values, ZippedGroupOperations(ops)) {

    constructor(v1: E1, v2: E2, op1: GroupOperation<E1>, op2: GroupOperation<E2>): this(Pair(v1, v2), Pair(op1, op2))

}
