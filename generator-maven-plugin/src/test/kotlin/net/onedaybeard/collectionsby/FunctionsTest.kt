package net.onedaybeard.collectionsby

import org.junit.jupiter.api.Assertions.*
import kotlin.reflect.KFunction
import kotlin.test.Test

class FunctionsTest {
    @Test
    fun `find functions from class name`() {
        val functionsA = findFunctions("kotlin.collections.CollectionsKt")
        val functionsB = findFunctions("kotlin.sequences.SequencesKt")
        val functionsC = findFunctions("kotlin.collections.ArraysKt")
        val functions = functionsA + functionsB + functionsC

        val grouped = functions.groupBy(KFunction<*>::extensionIdentifier)
                .map { (k, v) -> k?.substringAfterLast(".") to v }
                .toMap()

        println(functions)

    }
}