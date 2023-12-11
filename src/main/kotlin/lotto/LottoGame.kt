package lotto

import lotto.controller.LottoController
import lotto.controller.MoneyController

class LottoGame {
    private val moneyController = MoneyController()
    private val lottoController = LottoController()

    fun run() {
        setLottoMoney()
        publishLotto()
    }

    private fun setLottoMoney() {
        moneyController.set()
    }

    private fun publishLotto() {
        lottoController.publish()
    }
}