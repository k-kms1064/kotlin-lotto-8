package lotto

class LottoResult(
    private val results: Map<Rank, Int>
) {

    companion object {
        fun from(lottos: List<Lotto>, winningLotto: WinningLotto): LottoResult {
            val resultMap = mutableMapOf<Rank, Int>()

            lottos.forEach { lotto ->
                val rank = winningLotto.match(lotto)
                resultMap[rank] = resultMap.getOrDefault(rank, 0) + 1
            }

            return LottoResult(resultMap)
        }
    }

    fun getCount(rank: Rank): Int {
        return results.getOrDefault(rank, 0)
    }
}
