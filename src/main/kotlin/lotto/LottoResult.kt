package lotto

class LottoResult(
    private val results: Map<Rank, Int>
) {

    fun getCount(rank: Rank): Int {
        return results.getOrDefault(rank, 0)
    }
}
