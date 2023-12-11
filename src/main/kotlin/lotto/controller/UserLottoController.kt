package lotto.controller

import lotto.InputView
import lotto.OutputView
import lotto.domain.LottoMoney
import lotto.state.ControllerState.*

class UserLottoController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private lateinit var lottoMoney: LottoMoney
    private var controllerState = NORMAL

    fun saleLotto() {
        getMoneyFromUser()
    }

    private fun getMoneyFromUser() {
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
            lottoMoney = LottoMoney(readNumberFromUser())
            controllerState = NORMAL
        } catch (e: IllegalArgumentException) {
            requestMoneyOnError()
            controllerState = ERROR
        }
    }

    private fun requestMoney() {
        outputView.printRequestMoneyMessage()
    }

    private fun requestMoneyOnError() {
        outputView.printErrorOnRequestMoney()
    }

    private fun readNumberFromUser() = inputView.readNumber()

    private fun isControllerOnError() = controllerState == ERROR
}