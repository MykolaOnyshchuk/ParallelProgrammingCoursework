class HelperMethods {
    fun insertionSortBack(A: Array<Employee?>, cmp: Comparator<Employee>) {
        for (i in 1 until A.size) {
            val key = A[i]
            var j = i - 1
            while (j >= 0 && cmp.compare(A[j], key) < 0) {
                A[j + 1] = A[j]
                j -= 1
            }
            A[j + 1] = key
        }
    }

    fun makeArrayAlmostSorted(A: Array<Employee?>, step: Int) {
        var helpingArr: Array<Employee?> = arrayOfNulls<Employee>((A.size + (step - 1)) / step)
        for (i in A.indices) {
            if (i % step == 0) {
                helpingArr[i / step] = A[i]
            }
        }
        helpingArr.shuffle()
        for (i in A.indices) {
            if (i % step == 0) {
                A[i] = helpingArr[i / step]
            }
        }
    }
}