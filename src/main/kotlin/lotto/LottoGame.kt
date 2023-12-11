package lotto

import lotto.controller.LottoController
import lotto.controller.MoneyController
import lotto.controller.WinningController

class LottoGame {
    private val moneyController = MoneyController()
    private val lottoController = LottoController()
    private val winningController = WinningController()

    fun run() {
        setLottoMoney()
        publishLotto()
        pickWinningNumbers()
    }

    private fun setLottoMoney() {
        moneyController.set()
    }

    private fun publishLotto() {
        lottoController.publish(moneyController.availableLottoCount())
    }

    private fun pickWinningNumbers() {
        winningController.pickNumbers()
    }
}