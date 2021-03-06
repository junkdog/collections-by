package net.onedaybeard.collectionsby

import java.lang.reflect.Method
import kotlin.reflect.*
import kotlin.reflect.KParameter.Kind.EXTENSION_RECEIVER
import kotlin.reflect.full.extensionReceiverParameter
import kotlin.reflect.jvm.kotlinFunction

fun KFunction<*>.extensionReceiverType(): String =
        extensionReceiverParameter?.type?.toString() ?: ""

fun generateFun(receiver: String, name: String) = """
    fun <T, U> $receiver.${name}By(selector: (T) -> U, match: U) =
        $name(by(selector, match))
    fun <T, U> $receiver.${name}By(selector: (T) -> U, predicate: (U) -> Boolean) =
        $name(by(selector, predicate))
        
""".trimIndent()

fun generateFuns(
        packageName: String,
        receiver: String,
        functions: Iterable<String>
): String {

    val simpleNameT = receiver.substringAfterLast(".")
    return "package $packageName\n\n" + functions
            .sorted()
            .map { f -> generateFun(simpleNameT, f) }
            .joinToString("\n")
}

@ExperimentalStdlibApi
fun findPredicateFunctions(className: String): List<KFunction<*>> {
    return Class.forName(className)
            .methods
            .mapNotNull(Method::kotlinFunction)
            .filter { f -> f.parameters.size == 2 }
            .filter { f -> f.parameters[0].kind == EXTENSION_RECEIVER }
            .filter(KFunction<*>::hasPredicateParameter)
}

@ExperimentalStdlibApi
private fun KFunction<*>.hasPredicateParameter(): Boolean {
    val arguments = parameters[1].type.arguments
    if (arguments.size != 2) return false

    val (param, ret) = arguments
            .mapNotNull(KTypeProjection::type)

    return param.toString() == "T" && ret == typeOf<Boolean>()
}

