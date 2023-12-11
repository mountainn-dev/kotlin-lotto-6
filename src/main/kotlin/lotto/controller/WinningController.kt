package lotto.controller

import lotto.InputView
import lotto.OutputView
import lotto.domain.Lotto
import lotto.domain.Winning
import lotto.state.ControllerState.*

class WinningController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var controllerState = NORMAL
    private lateinit var winning: Winning
    private lateinit var winningNumbers: List<Int>

    fun pickNumbers() {
        pickWinningNumbers()
    }

    private fun pickWinningNumbers() {
        requestWinningNumbers()
        setValidWinningNumbers()
    }

    private fun requestWinningNumbers() {
        outputView.printRequestWinningNumbers()
    }

    private fun setValidWinningNumbers() {
        do {
            setWinningNumbers()
        } while (isControllerOnError())
    }

    private fun setWinningNumbers() {
        try {
            winningNumbers = readNumbersFromUser()
            Lotto(winningNumbers)
            controllerState = NORMAL
        } catch (e: IllegalArgumentException) {
            requestWinningNumbersOnError()
            controllerState = ERROR
        }
    }

    private fun requestWinningNumbersOnError() {
        outputView.printErrorOnRequestWinningNumbers()
    }

    private fun readNumbersFromUser() = inputView.readNumbers()

    private fun isControllerOnError() = controllerState == ERROR
}