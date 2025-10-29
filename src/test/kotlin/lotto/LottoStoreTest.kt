package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoStoreTest {

    private val store = LottoStore()

    @Test
    fun `1000원 단위가 아니면 예외 발생`() {
        Assertions.assertThatThrownBy { store.buy(1500) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("[ERROR]")
    }

    @Test
    fun `구입 금액에 따라 로또를 올바른 개수만큼 발행한다`() {
        val lottos = store.buy(3000)
        Assertions.assertThat(lottos).hasSize(3)
    }
}