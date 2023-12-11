package lotto

import lotto.constants.Exception
import lotto.constants.Request
import lotto.constants.Result
import lotto.domain.Lotto

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
}