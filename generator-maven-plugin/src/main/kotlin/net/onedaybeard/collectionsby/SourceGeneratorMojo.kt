package net.onedaybeard.collectionsby

import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase.GENERATE_SOURCES
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.plugins.annotations.ResolutionScope.COMPILE
import java.io.File
import kotlin.reflect.KFunction


@Mojo(
    name = "generate",
    defaultPhase = GENERATE_SOURCES,
    requiresDependencyResolution = COMPILE)
class SourceGeneratorMojo : AbstractMojo() {

    @Parameter(property = "project.build.directory", readonly = true)
    private lateinit var build: File

    @ExperimentalStdlibApi
    override fun execute() {
        val classesToInspect = listOf(
                "kotlin.collections.CollectionsKt",
                "kotlin.collections.ArraysKt",
                "kotlin.sequences.SequencesKt")

        val packageName = "net.onedaybeard.collectionsby"

        val outputDir = File("$build/generated-sources/kotlin/${packageName.replace('.', '/')}")
                .apply { mkdirs() }

        classesToInspect
                .flatMap(::findPredicateFunctions)
                .groupBy(KFunction<*>::extensionReceiverType)
                .map { (cls, fns) -> cls to fns.map(KFunction<*>::name) }
                .map { (cls, fns) -> cls to generateFuns(packageName, cls, fns + "find") }
                .map { (cls, impl) -> cls.substringAfterLast(".").substringBefore("<") to impl }
                .forEach { (name, impl) -> File(outputDir, "${name}By.kt").writeText(impl) }
    }
}
