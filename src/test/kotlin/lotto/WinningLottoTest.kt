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
}
