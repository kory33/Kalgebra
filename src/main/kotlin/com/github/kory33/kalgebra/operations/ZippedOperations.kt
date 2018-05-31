package com.github.kory33.kalgebra.operations

abstract class ZippedMagmaOperation<M1, M2> : MagmaOperation<Pair<M1, M2>> {

    protected abstract val operation1: MagmaOperation<M1>
    protected abstract val operation2: MagmaOperation<M2>

    override fun invoke(p1: Pair<M1, M2>, p2: Pair<M1, M2>): Pair<M1, M2> =
            Pair(operation1(p1.first, p2.first), operation2(p1.second, p2.second))

    companion object {
        operator fun <M1, M2> invoke(operations: Pair<MagmaOperation<M1>, MagmaOperation<M2>>): ZippedMagmaOperation<M1, M2> {
            return object: ZippedMagmaOperation<M1, M2>() {
                override val operation1 = operations.first
                override val operation2 = operations.second
            }
        }

        operator fun <M1, M2> invoke(operation1: MagmaOperation<M1>, operation2: MagmaOperation<M2>) =
                invoke(Pair(operation1, operation2))
    }

}

abstract class ZippedMonoidOperation<M1, M2>: ZippedMagmaOperation<M1, M2>(), MonoidOperation<Pair<M1, M2>> {

    abstract override val operation1: MonoidOperation<M1>
    abstract override val operation2: MonoidOperation<M2>

    override val identity: Pair<M1, M2> by lazy { Pair(operation1.identity, operation2.identity) }

    companion object {
        operator fun <M1, M2> invoke(operations: Pair<MonoidOperation<M1>, MonoidOperation<M2>>): ZippedMonoidOperation<M1, M2> {
            return object: ZippedMonoidOperation<M1, M2>() {
                override val operation1 = operations.first
                override val operation2 = operations.second
            }
        }

        operator fun <M1, M2> invoke(operation1: MonoidOperation<M1>, operation2: MonoidOperation<M2>) =
                invoke(Pair(operation1, operation2))
    }

}

abstract class ZippedGroupOperation<M1, M2>: ZippedMonoidOperation<M1, M2>(), GroupOperation<Pair<M1, M2>> {

    abstract override val operation1: GroupOperation<M1>
    abstract override val operation2: GroupOperation<M2>

    override val Pair<M1, M2>.inverse: Pair<M1, M2>
        get() = Pair(
            operation1.run { this@inverse.first.inverse },
            operation2.run { this@inverse.second.inverse }
        )

    companion object {
        operator fun <M1, M2> invoke(operations: Pair<GroupOperation<M1>, GroupOperation<M2>>): ZippedGroupOperation<M1, M2> {
            return object: ZippedGroupOperation<M1, M2>() {
                override val operation1 = operations.first
                override val operation2 = operations.second
            }
        }

        operator fun <M1, M2> invoke(operation1: GroupOperation<M1>, operation2: GroupOperation<M2>) =
                invoke(Pair(operation1, operation2))
    }

}
