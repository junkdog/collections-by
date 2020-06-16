package net.onedaybeard.collectionsby

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase.GENERATE_SOURCES
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.plugins.annotations.ResolutionScope.COMPILE_PLUS_RUNTIME
import java.io.File
import kotlin.reflect.KFunction


/**
 * Applies transplants during build. As such, only compiled classes
 * are affected.
 */
@Mojo(
    name = "generate",
    defaultPhase = GENERATE_SOURCES,
    requiresDependencyResolution = COMPILE_PLUS_RUNTIME)
class SourceGeneratorMojo : AbstractMojo() {

    @Parameter(property = "project.build.directory", readonly = true)
    private lateinit var build: File

    override fun execute() {
        val classesToInspect = listOf(
                "kotlin.collections.CollectionsKt",
                "kotlin.collections.ArraysKt",
                "kotlin.sequences.SequencesKt")

        val packageName = "net.onedaybeard.collectionsby"

        val root = File("$build/generated-sources/kotlin/${packageName.replace('.', '/')}")
                .apply { mkdirs() }

        classesToInspect
                .flatMap(::findFunctions)
                .groupBy(KFunction<*>::extensionIdentifier)
                .map { (k, v) -> k!! to v.map(KFunction<*>::name) }
                .map { (k, v) -> k to generateFuns(packageName, k, v + "find") }
                .map { (k, v) -> k.substringAfterLast(".").substringBefore("<") to v}
                .forEach { (k, v) -> File(root, "${k}By.kt").writeText(v) }
    }
}
