package lotto

import lotto.constants.Exception
import lotto.constants.Request
import lotto.constants.Result
import lotto.domain.Lotto
import lotto.domain.WinningRank
import lotto.domain.WinningRank.*

class OutputView {

    fun printRequestMoneyMessage() {
        println(Request.REQUEST_MONEY_MESSAGE)
    }

    fun printErrorOnRequestMoney() {
        println(Exception.ERROR_REQUEST_MONEY)
    }

    fun printResultPublish(userLotto: List<Lotto>) {
        printTotalCount(userLotto.size)
        printTotalLotto(userLotto)
    }

    private fun printTotalCount(count: Int) {
        println(String.format(Result.RESULT_PUBLISH_COUNT_MESSAGE, count))
    }

    private fun printTotalLotto(userLotto: List<Lotto>) {
        userLotto.map { println(it.numbers().sorted()) }
    }

    fun printRequestWinningNumbers() {
        println(Request.REQUEST_WINNING_NUMBERS)
    }

    fun printErrorOnRequestWinningNumbers() {
        println(Exception.ERROR_REQUEST_WINNING_NUMBERS)
    }

    fun printRequestBonusNumber() {
        println(Request.REQUEST_BONUS_NUMBER)
    }

    fun printErrorOnRequestBonusNumber() {
        println(Exception.ERROR_REQUEST_BONUS_NUMBER)
    }

    fun printResultWinning(winningResult: List<WinningRank>) {
        WinningRank.values().sortedBy { it.reward() }.map {
            if (it != NOTHING) printResultRankByMatchCount(it, winningResult.count { result -> result == it })
        }
    }

    private fun printResultRankByMatchCount(winningRank: WinningRank, count: Int) {
        if (winningRank.bonusCondition()) printResultRankWithBonus(winningRank, count)
        else printResultRankWithoutBonus(winningRank, count)
    }

    private fun printResultRankWithoutBonus(winningRank: WinningRank, count: Int) {
        println(String.format(Result.RESULT_WINNING_NOT_BONUS, winningRank.conditionCount(), winningRank.reward(), count))
    }

    private fun printResultRankWithBonus(winningRank: WinningRank, count: Int) {
        println(String.format(Result.RESULT_WINNING_BONUS, winningRank.conditionCount(), winningRank.reward(), count))
    }
}