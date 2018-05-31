package com.github.kory33.kalgebra.structures.instances.group

import com.github.kory33.kalgebra.operations.GroupOperation
import com.github.kory33.kalgebra.operations.ZippedGroupOperation
import com.github.kory33.kalgebra.structures.Group

abstract class GroupProduct<E1, E2, G: GroupProduct<E1, E2, G>>(
        values: Pair<E1, E2>,
        ops: Pair<GroupOperation<E1>, GroupOperation<E2>>
) : Group<Pair<E1, E2>, GroupProduct<E1, E2, G>>(values, ZippedGroupOperation(ops)) {

    constructor(v1: E1, v2: E2, op1: GroupOperation<E1>, op2: GroupOperation<E2>): this(Pair(v1, v2), Pair(op1, op2))

}
