package lotto

class WinningLotto(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {

    init {
        require(bonusNumber in 1..45) { "[ERROR] 보너스 번호는 1부터 45 사이여야 합니다." }
        require(!winningNumbers.getNumbers().contains(bonusNumber)) { "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun match(userLotto: Lotto): Rank {
        val matchCount = userLotto.getNumbers().count { it in winningNumbers.getNumbers() }
        val matchBonus = userLotto.getNumbers().contains(bonusNumber)
        return Rank.of(matchCount, matchBonus)
    }
}
