import java.util.*
import java.util.concurrent.RecursiveAction

internal class MergeFJ constructor(val A: Array<Employee?>, val  ll: Int, val lh: Int,
                                   val rl: Int, val rh: Int, val b: Int, val cmp: Comparator<Employee>) :
    RecursiveAction() {

    override fun compute() {
        if (lh - ll + 1 <= b) {
            if (cmp.compare(A[lh], A[rl]) > 0) {
                for (i in rl..rh) {
                    val key = A[i]
                    var j = i - 1
                    while (j >= rl && cmp.compare(A[j], key) > 0) {
                        A[j + 1] = A[j]
                        j -= 1
                    }
                    if (cmp.compare(A[lh], key) > 0) {
                        A[rl] = A[lh]
                        j = lh - 1
                        while (j >= ll && cmp.compare(A[j], key) > 0) {
                            A[j + 1] = A[j]
                            j -= 1
                        }
                    }
                    A[j + 1] = key
                }
            }

        } else {
            val lm = (ll + lh) / 2
            val rm = (rl + rh) / 2

            invokeAll(MergeFJ(A, ll, lm, rl, rm, b, cmp),
                    MergeFJ(A, lm + 1, lh, rm + 1, rh, b, cmp))

            MergeFJ(A, lm + 1, lh, rl, rm, b, cmp).invoke()
        }
    }

}