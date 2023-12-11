package lotto

import lotto.constants.Exception
import lotto.constants.Request

class OutputView {

    fun printRequestMoneyMessage() {
        println(Request.REQUEST_MONEY_MESSAGE)
    }

    fun printErrorOnRequestMoney() {
        println(Exception.ERROR_REQUEST_MONEY)
    }
}