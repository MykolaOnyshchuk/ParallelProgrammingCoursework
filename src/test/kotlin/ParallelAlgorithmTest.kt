import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows


internal class ParallelAlgorithmTest {

    private val comparatorArr: Array<Comparator<Employee>> = arrayOf(ComparatorNameEmployee(),
        ComparatorSurnameEmployee(), ComparatorSexEmployee(), ComparatorAgeEmployee(),
        ComparatorHeightEmployee(), ComparatorWeightEmployee(), ComparatorCompanyEmployee(),
        ComparatorHierarchyLevelEmployee(), ComparatorProfessionEmployee(), ComparatorExperienceInCurrentPositionEmployee(),
        ComparatorExperienceInCurrentCompanyEmployee(), ComparatorSalaryEmployee())

    private fun isSorted(arr: Array<Employee?>, cmp: Comparator<Employee>): Boolean {
        for (i in 0 until arr.size - 1) {
            if (cmp.compare(arr[i], arr[i + 1]) > 0) return false
        }
        return true
    }

    @Test
    fun sortGeneratedArrayParallelT() {
        val arrayGenerator = EmployeeArrayGenerator()
        val insertionSortParT = InsertionSortParT()
        for (cmp in comparatorArr) {
            val objArray = arrayGenerator.generateArray(1000)
            insertionSortParT.insertionSortPar(objArray, 0, objArray.size - 1, 50, cmp)
            assertTrue(isSorted(objArray, cmp))
        }
    }

    @Test
    fun sortGeneratedArrayParallelFJ() {
        val arrayGenerator = EmployeeArrayGenerator()
        val insertionSortParT = InsertionSortParT()
        for (cmp in comparatorArr) {
            val objArray = arrayGenerator.generateArray(1000)
            insertionSortParT.insertionSortPar(objArray, 0, objArray.size - 1, 50, cmp)
            assertTrue(isSorted(objArray, cmp))
        }
    }

    @Test
    fun sortEmptyArrayParallelT() {
        for (cmp in comparatorArr) {
            val objArray = emptyArray<Employee?>()
            InsertionSortParFJ(objArray, 0, objArray.size - 1, 50, cmp).invoke()
            assertTrue((isSorted(objArray, cmp) && objArray.isEmpty()))
        }
    }

    @Test
    fun sortEmptyArrayParallelFJ() {
        for (cmp in comparatorArr) {
            val objArray = emptyArray<Employee?>()
            InsertionSortParFJ(objArray, 0, objArray.size - 1, 50, cmp).invoke()
            assertTrue((isSorted(objArray, cmp) && objArray.isEmpty()))
        }
    }

    @Test
    fun sortSortedArrayParallelT() {
        val arrayGenerator = EmployeeArrayGenerator()
        val stepByStepAlgorithm = StepByStepAlgorithm()
        val insertionSortParT = InsertionSortParT()
        for (cmp in comparatorArr) {
            val objArray = arrayGenerator.generateArray(1000)
            stepByStepAlgorithm.insertionSort(objArray, cmp)
            insertionSortParT.insertionSortPar(objArray, 0, objArray.size - 1, 50, cmp)
            assertTrue(isSorted(objArray, cmp))
        }
    }

    @Test
    fun sortSortedArrayParallelFJ() {
        val arrayGenerator = EmployeeArrayGenerator()
        val stepByStepAlgorithm = StepByStepAlgorithm()
        for (cmp in comparatorArr) {
            val objArray = arrayGenerator.generateArray(1000)
            stepByStepAlgorithm.insertionSort(objArray, cmp)
            InsertionSortParFJ(objArray, 0, objArray.size - 1, 50, cmp).invoke()
            assertTrue(isSorted(objArray, cmp))
        }
    }

    @Test
    fun sortIdenticalElementsArrayParallelT() {
        val arrayGenerator = EmployeeArrayGenerator()
        val insertionSortParT = InsertionSortParT()
        for (cmp in comparatorArr) {
            val objArray = arrayGenerator.generateIdenticalElementsArray(1000)
            val arrayCopy = objArray.copyOf()
            insertionSortParT.insertionSortPar(objArray, 0, objArray.size - 1, 50, cmp)
            assertTrue(objArray.contentEquals(arrayCopy))
        }
    }

    @Test
    fun sortIdenticalElementsArrayParallelFJ() {
        val arrayGenerator = EmployeeArrayGenerator()
        for (cmp in comparatorArr) {
            val objArray = arrayGenerator.generateIdenticalElementsArray(1000)
            val arrayCopy = objArray.copyOf()
            InsertionSortParFJ(objArray, 0, objArray.size - 1, 50, cmp).invoke()
            assertTrue(objArray.contentEquals(arrayCopy))
        }
    }

    @Test
    fun sortArrayWithNullParallelT() {
        val arrayGenerator = EmployeeArrayGenerator()
        val insertionSortParT = InsertionSortParT()
        for (cmp in comparatorArr) {
            assertThrows<NullPointerException> {
                val objArray = arrayGenerator.generateArray(1000)
                objArray[700] = null
                insertionSortParT.insertionSortPar(objArray, 0, objArray.size - 1, 50, cmp)
            }
        }
    }

    @Test
    fun sortArrayWithNullParallelFJ() {
        val arrayGenerator = EmployeeArrayGenerator()
        for (cmp in comparatorArr) {
            assertThrows<NullPointerException> {
                val objArray = arrayGenerator.generateArray(1000)
                objArray[700] = null
                InsertionSortParFJ(objArray, 0, objArray.size - 1, 50, cmp).invoke()
            }
        }
    }

    @Test
    fun parallelFasterThanStepByStepT() {
        val arrayGenerator = EmployeeArrayGenerator()
        val stepByStepAlgorithm = StepByStepAlgorithm()
        val insertionSortParT = InsertionSortParT()
        val nameCmp: Comparator<Employee> = ComparatorNameEmployee()
        var objArray = arrayGenerator.generateArray(100000)

        var startTimeStepByStep: Double = System.nanoTime().toDouble()
        stepByStepAlgorithm.insertionSort(objArray, nameCmp)
        var executionTimeStepByStep: Double = (System.nanoTime() - startTimeStepByStep) / 1000000000F

        val thresholds = arrayOf(100, 500, 1000)

        for (t in thresholds) {
            objArray = arrayGenerator.generateArray(100000)
            var startTimeParallel: Double = System.nanoTime().toDouble()
            insertionSortParT.insertionSortPar(objArray, 0, objArray.size - 1, t, nameCmp)
            var executionTimeParallel: Double = (System.nanoTime() - startTimeParallel) / 1000000000F
            assertTrue(executionTimeParallel < executionTimeStepByStep )
        }
    }

    @Test
    fun parallelFasterThanStepByStepFJ() {
        val arrayGenerator = EmployeeArrayGenerator()
        val stepByStepAlgorithm = StepByStepAlgorithm()
        val nameCmp: Comparator<Employee> = ComparatorNameEmployee()
        var objArray = arrayGenerator.generateArray(100000)

        var startTimeStepByStep: Double = System.nanoTime().toDouble()
        stepByStepAlgorithm.insertionSort(objArray, nameCmp)
        var executionTimeStepByStep: Double = (System.nanoTime() - startTimeStepByStep) / 1000000000F

        val thresholds = arrayOf(100, 500, 1000)

        for (t in thresholds) {
            objArray = arrayGenerator.generateArray(100000)
            var startTimeParallel: Double = System.nanoTime().toDouble()
            InsertionSortParFJ(objArray, 0, objArray.size - 1, t, nameCmp).invoke()
            var executionTimeParallel: Double = (System.nanoTime() - startTimeParallel) / 1000000000F
            assertTrue(executionTimeParallel < executionTimeStepByStep )
        }
    }
}