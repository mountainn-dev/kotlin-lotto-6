package lotto

import lotto.controller.UserLottoController

class LottoGame {
    private val userLottoController = UserLottoController()

    fun run() {
        buyLotto()
    }

    private fun buyLotto() {
        userLottoController.saleLotto()
    }
}