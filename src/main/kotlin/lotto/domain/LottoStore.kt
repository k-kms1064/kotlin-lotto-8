    package lotto.domain

    class LottoStore(
        private val generator: LottoGenerator = RandomLottoGenerator()
    ) {

        fun buy(amount: Int): List<Lotto> {
            require(amount % 1000 == 0) { "[ERROR] 구입 금액은 1000원 단위여야 합니다." }

            val count = amount / 1000
            val lottos = mutableListOf<Lotto>()

            repeat(count) {
                lottos.add(generator.generate())
            }

            return lottos
        }
    }
