package lotto

import camp.nextstep.edu.missionutils.Console

fun main() {
    Application().run()
}

class Application {

    fun run() {
        val store = LottoStore()
        val amount = readPurchaseAmount()
        val lottos = store.buy(amount)

        println("${lottos.size}개를 구매했습니다.")
        lottos.forEach { println(it.getNumbers()) }

        val winningLotto = readWinningLotto()
        val result = LottoResult.from(lottos, winningLotto)
        printResult(result, amount)
    }

    private fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        val input = Console.readLine()
        return input.toIntOrNull()?.takeIf { it % 1000 == 0 }
            ?: throw IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위의 숫자여야 합니다.")
    }

    private fun readWinningLotto(): WinningLotto {
        println("\n당첨 번호를 입력해 주세요.")
        val winningNumbers = Console.readLine().split(",").map { it.trim().toInt() }
        val lotto = Lotto(winningNumbers)

        println("\n보너스 번호를 입력해 주세요.")
        val bonusNumber = Console.readLine().trim().toInt()

        return WinningLotto(lotto, bonusNumber)
    }

    private fun printResult(result: LottoResult, totalAmount: Int) {
        println("\n당첨 통계\n---")
        Rank.values()
            .filter { it != Rank.NONE }
            .sortedByDescending { it.reward }
            .forEach { rank ->
                val matchText = when (rank) {
                    Rank.SECOND -> "5개 일치, 보너스 볼 일치"
                    else -> "${rank.matchCount}개 일치"
                }
                println("$matchText (${rank.reward}원) - ${result.getCount(rank)}개")
            }

        val rate = result.calculateProfitRate(totalAmount)
        val formatted = String.format("%.1f", rate)
        println("총 수익률은 ${formatted}%입니다.")
    }
}
