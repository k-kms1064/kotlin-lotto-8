package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultTest {

    @Test
    fun `로또 결과를 등수별로 집계한다`() {
        val winning = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val lottos = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)), // 1등
            Lotto(listOf(1, 2, 3, 4, 5, 7)), // 2등
            Lotto(listOf(1, 2, 3, 4, 8, 9))  // 4등
        )

        val result = LottoResult.from(lottos, winning)

        assertThat(result.getCount(Rank.FIRST)).isEqualTo(1)
        assertThat(result.getCount(Rank.SECOND)).isEqualTo(1)
        assertThat(result.getCount(Rank.FOURTH)).isEqualTo(1)
    }

    @Test
    fun `총 수익률을 계산한다`() {
        val result = LottoResult(
            mapOf(
                Rank.FIRST to 1,
                Rank.FIFTH to 1
            )
        )

        val rate = result.calculateProfitRate(totalPurchase = 2000)
        assertThat(rate).isEqualTo((2_000_000_000 + 5_000) / 2000.0 * 100)
    }
}
