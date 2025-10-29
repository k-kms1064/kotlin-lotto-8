package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class RandomLottoGenerator : LottoGenerator {

    override fun generate(): Lotto {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(numbers)
    }
}
