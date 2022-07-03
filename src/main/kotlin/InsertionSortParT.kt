class InsertionSortParT {
    private fun merge (A: Array<Employee?>, ll: Int, lh: Int, rl: Int, rh: Int, b: Int, cmp: Comparator<Employee>) {
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
            var thread1:Thread = Thread(Runnable{
                merge(A, ll, lm, rl, rm, b, cmp)
            })
            var thread2:Thread = Thread(Runnable{
                merge(A, lm + 1, lh, rm + 1, rh, b, cmp)
            })

            thread1.start()
            thread2.start()
            thread1.join()
            thread2.join()

            merge(A, lm + 1, lh, rl, rm, b, cmp)
        }
    }

    fun insertionSortPar(A: Array<Employee?>, l: Int, h: Int, b: Int, cmp: Comparator<Employee>) {
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
            var thread1:Thread = Thread(Runnable{
                insertionSortPar(A, l, m, b, cmp)
            })
            var thread2:Thread = Thread(Runnable{
                insertionSortPar(A, m + 1, h, b, cmp)
            })

            thread1.start()
            thread2.start()
            thread1.join()
            thread2.join()

            merge(A, l, m, m + 1, h, b, cmp)
        }
    }
}