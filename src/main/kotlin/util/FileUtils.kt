package util

import java.io.File

internal object FileUtils {
    fun fileAsList(fileName: String): List<String> =
        File(
            FileUtils::javaClass.javaClass.classLoader.getResource(fileName)?.toURI()
                ?: throw IllegalArgumentException("Cannot find file: $fileName")
        ).useLines { it.toList() }


    fun fileAsIntList(fileName: String): List<Int> = fileAsList(fileName).map { it.toInt() }

    fun fileAsIntArray(fileName: String): Array<Int> = fileAsList(fileName).map { it.toInt() }.toTypedArray()
}