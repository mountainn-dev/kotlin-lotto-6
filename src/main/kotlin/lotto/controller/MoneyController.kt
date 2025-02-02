package lotto.controller

import lotto.InputView
import lotto.OutputView
import lotto.domain.LottoMoney
import lotto.state.ControllerState

class MoneyController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var money: LottoMoney
    private var controllerState = ControllerState.NORMAL

    fun availableLottoCount() = money.availableLottoCount()

    fun set() {
        requestMoney()
        setValidMoney()
    }

    private fun setValidMoney() {
        do {
            setMoney()
        } while (isControllerOnError())
    }

    private fun setMoney() {
        try {
            money = LottoMoney(readNumberFromUser())
            controllerState = ControllerState.NORMAL
        } catch (e: IllegalArgumentException) {
            requestMoneyOnError()
            controllerState = ControllerState.ERROR
        }
    }


    private fun requestMoney() {
        outputView.printRequestMoneyMessage()
    }

    private fun requestMoneyOnError() {
        outputView.printErrorOnRequestMoney()
    }

    private fun readNumberFromUser() = inputView.readNumber()

    private fun isControllerOnError() = controllerState == ControllerState.ERROR
}