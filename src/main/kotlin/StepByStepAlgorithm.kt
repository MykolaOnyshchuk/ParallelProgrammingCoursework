class StepByStepAlgorithm {
    fun insertionSort(A: Array<Employee?>, cmp: Comparator<Employee>) {
        for (i in 1 until A.size) {
            val key = A[i]
            var j = i - 1
            while (j >= 0 && cmp.compare(A[j], key) > 0) {
                A[j + 1] = A[j]
                j -= 1
            }
            A[j + 1] = key
        }
    }
}