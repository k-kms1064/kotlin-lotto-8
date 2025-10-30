package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class WinningLottoTest {

    @Test
    fun `보너스 번호가 1~45 범위를 벗어나면 예외 발생`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThatThrownBy { WinningLotto(winningNumbers, 46) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `보너스 번호가 당첨 번호와 중복되면 예외 발생`() {
        val winningNumbers = Lotto(listOf(1, 2, 3, 4, 5, 6))
        assertThatThrownBy { WinningLotto(winningNumbers, 6) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `3개 일치 시 5등`() {
        val winning = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val result = winning.match(Lotto(listOf(1, 2, 3, 10, 11, 12)))
        assertThat(result).isEqualTo(Rank.FIFTH)
    }

    @Test
    fun `5개 일치 + 보너스 번호 일치 시 2등`() {
        val winning = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val result = winning.match(Lotto(listOf(1, 2, 3, 4, 5, 7)))
        assertThat(result).isEqualTo(Rank.SECOND)
    }

    @Test
    fun `6개 일치 시 1등`() {
        val winning = WinningLotto(Lotto(listOf(1, 2, 3, 4, 5, 6)), 7)
        val result = winning.match(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        assertThat(result).isEqualTo(Rank.FIRST)
    }
}
