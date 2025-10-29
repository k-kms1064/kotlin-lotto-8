package lotto.domain

class LottoStore(
    private val generator: LottoGenerator = RandomLottoGenerator()
) {

    fun buy(amount: Int): List<Lotto> {
        return emptyList()
    }
}
