package net.onedaybeard.collectionsby

import java.lang.reflect.Method
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

const val ROOT = "net.onedaybeard.collectionsby.IterableByKt"

infix fun <T, U> T.to(matcher:  (U) -> T): (U) -> Boolean
    = by(matcher, this)
infix fun <T, U> T.of(matcher:  (U) -> T): (U) -> Boolean
    = by(matcher, this)
infix fun <T, U> T.by(matcher:  (U) -> T): (U) -> Boolean
    = by(matcher, this)
infix fun <T, U> ((U) -> T).to(match: T): (U) -> Boolean
    = by(this, match)
//infix fun <T, U> (() -> T).from(matcher:  (T) -> U): (T) -> Boolean
//    = by(matcher, this)

class IterableByTest {

    val list = (1..10).map(Int::toString).toList()
    val names = """
        darius
        mary
        demarcus
        amadou
        willie
        terrill
        sylville
        demetrius
        alton
        philando
        terence
        paul
        alteria
        bobby
        jordan
        aaron
        ronell
        stephon
        corey
        antwon
        tayler
        malice
        ramarley
        elijah
        aiyana
        botham
        pamela
        dominique
        sean
        atatiana
        jemel
        james
        ryan
        derrick
        addie
        carol
        carole
        cynthia
        nicholas
        christopher
        willie
        victor
        marcus
        martin
        christopher
        bradley
        timothy
        reginald
        danroy
        karvas
        eric
        korryn
        rekia
        kionte
        darius
        wayne
        manuel
        victor
        kobe
        clinton
        timothy
        corey
        tyre
        eric
        miles
        kendrick
        charleena
        michael
        trayvon
    """.trimIndent().lines()

    @Test
    fun `allBy test`() {



        list.any(10 by String::toInt)



        names.filter(5 by String::count)
        names.filter(5 to String::count)
        names.filter(String::toBoolean to true)

        list.callWith("allBy", String::toInt, 1, false)
        list.map { "10" }.callWith("allBy", String::toInt, 10, true)
    }

    @Test
    fun `anyBy test`() {
        list.callWith("anyBy", String::toInt, 10, true)

        assertTrue(list.anyBy(String::toInt, 1))
        assertTrue(list.anyBy(String::toInt) { 1 })
        assertTrue(list.map { "10" }.anyBy(String::toInt, 10))
        assertTrue(list.map { "10" }.anyBy(String::toInt) { 10 })
    }
}


infix fun <T, R> ((T) -> R).hmm(match: R): (T) -> Boolean {
    return { s: T ->this@hmm.invoke(s) == match }
}


private fun <R, T, U> Iterable<T>.callWith(
        function: String,
        selector: (T) -> U,
        match: U,
        asserting: (R) -> Unit
): R {
    fun Method.call(): Any {
        val matcher = when (parameterTypes.last().kotlin) {
            Function0::class -> ({ match } as () -> U)
            else -> match
        }
        return invoke(this@callWith, this@callWith, selector, matcher)
    }

    val (result1, result2) = findFunctions("$ROOT.$function")
            .map { fn -> fn.call() as R }

    assertEquals(result1, result2)
    asserting(result1)

    return result1
}

private fun <R, T, U> Iterable<T>.callWith(
        function: String,
        selector: (T) -> U,
        match: U,
        expected: R
): R = callWith(function, selector, match, { actual: R -> assertEquals(expected, actual)})

private fun findFunctions(qualifiedName: String): List<Method> {
    val functionName = qualifiedName.substringAfterLast(".")
    return Class.forName(qualifiedName.substringBeforeLast("."))
        .declaredMethods
        .toList()
        .filterBy(Method::getName, functionName)
}