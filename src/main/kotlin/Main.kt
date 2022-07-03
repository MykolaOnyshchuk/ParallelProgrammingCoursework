import java.util.concurrent.ForkJoinTask.invokeAll

object Main {
    @JvmStatic fun main(args: Array<String>) {
        val generator = EmployeeArrayGenerator()
        val stepByStepAlgorithm = StepByStepAlgorithm()
        val stepByStepInsertionMergeMix = StepByStepInsertionMergeMix()
        val helperMethods = HelperMethods()
        val nameComparator = ComparatorNameEmployee()
        val heightComparator = ComparatorHeightEmployee()
        val experienceInCurrentPositionComparator = ComparatorExperienceInCurrentPositionEmployee()
        val hierarchyLevelComparator = ComparatorHierarchyLevelEmployee()
        val unitedComparator = nameComparator.then(experienceInCurrentPositionComparator).then(heightComparator)


        var arr = generator.generateArray(200000)
        //helperMethods.insertionSortBack(arr, nameComparator)
//        arr.forEach { print("${it.toString()} \n") }
//        println("------------------------------------------------------------------------------------------------------------------------")
        //print("\n")
//        stepByStepAlgorithm.insertionSort(arr, experienceInCurrentPositionComparator)
//        helperMethods.makeArrayAlmostSorted(arr, 4)
        var startTime: Double = System.nanoTime().toDouble()
        //stepByStepAlgorithm.insertionSort(arr, nameComparator)
        //InsertionSortParT().insertionSortPar(arr, 0, arr.size - 1, 50000, experienceInCurrentPositionComparator)
        //stepByStepInsertionMergeMix.insertionSort(arr, 0, arr.size - 1, 100, heightComparator)
        InsertionSortParFJ(arr, 0, arr.size - 1, 50000, nameComparator).invoke()
        var executionTime: Double = (System.nanoTime() - startTime) / 1000000000F
        //arr.forEach { print("${it.toString()} \n") }
        print("\n" + executionTime)

    }
}