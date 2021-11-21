import util.FileUtils
import kotlin.math.roundToInt

internal object Day1 {
    fun getSolution(): Int {
        val ints = FileUtils.fileAsInts("day1.txt")

        return ints.fold(0) { acc, i -> acc + (kotlin.math.floor((i / 3).toDouble()) - 2).roundToInt() }
    }

}
