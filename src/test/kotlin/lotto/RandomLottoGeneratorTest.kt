package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.RepeatedTest

class RandomLottoGeneratorTest {

    private val generator = RandomLottoGenerator()

    @RepeatedTest(5)
    fun `랜덤 로또 번호는 6개의 고유한 숫자로 생성된다`() {
        val lotto = generator.generate()
        val numbers = lotto.getNumbers()

        Assertions.assertThat(numbers).hasSize(6)
        Assertions.assertThat(numbers.distinct().size).isEqualTo(6)
        Assertions.assertThat(numbers.all { it in 1..45 }).isTrue()
    }
}