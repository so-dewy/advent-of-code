import util.FileUtils
import kotlin.math.roundToInt

internal object Day1 {
    fun getSolutionPart1(): Int {
        val ints = FileUtils.fileAsIntList("day1.txt")

        return ints.fold(0) { acc, i -> acc +  calcFuelForMass(i) }
    }
    
    fun getSolutionPart2(): Int {
        val ints = FileUtils.fileAsIntList("day1.txt")

        return calcFuelForList(ints)
    }

    private fun calcFuelForList(masses: List<Int>, fuelAcc: Int = 0): Int {
        if (masses.isEmpty()) {
            return fuelAcc
        }

        val list = mutableListOf<Int>()
        var fuel = fuelAcc


        masses.forEach {
            val fuelForMass = calcFuelForMass(it)
            if (fuelForMass > 0) {
                fuel += fuelForMass
                list.add(fuelForMass)
            }
        }

        return calcFuelForList(list, fuel)
    }

    private fun calcFuelForMass(mass: Int) = (kotlin.math.floor((mass / 3).toDouble()) - 2).roundToInt()
}
