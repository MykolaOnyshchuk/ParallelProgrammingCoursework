import java.util.*
import java.util.concurrent.RecursiveAction

internal class InsertionSortParFJ constructor(val A: Array<Employee?>, val l: Int, val h: Int, val b: Int, val cmp: Comparator<Employee>) :
    RecursiveAction() {

    override fun compute() {
        if (h - l + 1 <= b) {
            for (i in l + 1..h) {
                val key = A[i]
                var j = i - 1
                while (j >= l && cmp.compare(A[j], key) > 0) {
                    A[j + 1] = A[j]
                    j -= 1
                }
                A[j + 1] = key
            }
        } else {
            val m = (l + h) / 2

            invokeAll(
                InsertionSortParFJ(A, l, m, b, cmp),
                InsertionSortParFJ(A, m + 1, h, b, cmp)
            )

            MergeFJ(A, l, m, m + 1, h, b, cmp).invoke()
        }
    }

}