package lotto.domain

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 번호가 6개가 아니면 예외 발생`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `로또 번호에 중복이 있으면 예외 발생`() {
        assertThatThrownBy { Lotto(listOf(1, 2, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `로또 번호가 1부터 45 사이가 아니면 예외 발생`() {
        assertThatThrownBy { Lotto(listOf(0, 2, 3, 4, 5, 6)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }
}
