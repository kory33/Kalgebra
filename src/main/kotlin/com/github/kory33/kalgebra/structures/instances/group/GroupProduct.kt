package com.github.kory33.kalgebra.structures.instances.group

import com.github.kory33.kalgebra.GroupOperation
import com.github.kory33.kalgebra.structures.Group
import com.github.kory33.kalgebra.structures.Magma

private class ZippedGroupOperations<A, B>(private val op1: GroupOperation<A>, private val op2: GroupOperation<B>)
    : GroupOperation<Pair<A, B>> {

    override fun invoke(p1: Pair<A, B>, p2: Pair<A, B>): Pair<A, B> =
            Pair(op1(p1.first, p2.first), op2(p1.second, p2.second))

    override val identity: Pair<A, B> = Pair(op1.identity, op2.identity)

    override val Pair<A, B>.inverse: Pair<A, B>
        get() = Pair(
                op1.run { this@inverse.first.inverse },
                op2.run { this@inverse.second.inverse }
        )

}

private fun <A, B> zipValues(magma1: Magma<A, *>, magma2: Magma<B, *>) = Pair(magma1.value, magma2.value)

class GroupProduct<E1, G1: Group<E1, G1>, E2, G2: Group<E2, G2>>(private val group1: G1, private val group2: G2)
    : Group<Pair<E1, E2>, GroupProduct<E1, G1, E2, G2>>(
        zipValues(group1, group2),
        ZippedGroupOperations(group1.operation, group2.operation)
    ) {

    override fun lift(value: Pair<E1, E2>): GroupProduct<E1, G1, E2, G2> =
            GroupProduct(group1.lift(value.first), group2.lift(value.second))

}

