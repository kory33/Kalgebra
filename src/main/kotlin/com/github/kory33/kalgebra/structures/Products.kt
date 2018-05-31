package com.github.kory33.kalgebra.structures

import com.github.kory33.kalgebra.operations.*

abstract class MagmaProduct<E1, E2, M: MagmaProduct<E1, E2, M>>(
        values: Pair<E1, E2>,
        operations: Pair<MagmaOperation<E1>, MagmaOperation<E2>>): Magma<Pair<E1, E2>, M>(values) {

    override val operation = ZippedMagmaOperation(operations)

}

abstract class MonoidProduct<E1, E2, M: MonoidProduct<E1, E2, M>>(
        values: Pair<E1, E2>,
        operations: Pair<MonoidOperation<E1>, MonoidOperation<E2>>
): Monoid<Pair<E1, E2>, M>(values) {

    override val operation: MonoidOperation<Pair<E1, E2>> = ZippedMonoidOperation(operations)

}

abstract class GroupProduct<E1, E2, G: GroupProduct<E1, E2, G>>(
        values: Pair<E1, E2>,
        operations: Pair<GroupOperation<E1>, GroupOperation<E2>>): Group<Pair<E1, E2>, G>(values) {

    override val operation: GroupOperation<Pair<E1, E2>> = ZippedGroupOperation(operations)

}
