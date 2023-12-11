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
        pickBonusNumber()
    }

    private fun pickWinningNumbers() {
        requestWinningNumbers()
        setValidWinningNumbers()
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

    private fun pickBonusNumber() {
        requestBonusNumber()
        setValidWinning()
    }

    private fun setValidWinning() {
        do {
            setWinning()
        } while (isControllerOnError())
    }

    private fun setWinning() {
        try {
            winning = Winning(winningNumbers, readNumberFromUser())
            controllerState = NORMAL
        } catch (e: IllegalArgumentException) {
            requestBonusNumberOnError()
            controllerState = ERROR
        }
    }

    private fun requestWinningNumbers() {
        outputView.printRequestWinningNumbers()
    }

    private fun requestWinningNumbersOnError() {
        outputView.printErrorOnRequestWinningNumbers()
    }

    private fun requestBonusNumber() {
        outputView.printRequestBonusNumber()
    }

    private fun requestBonusNumberOnError() {
        outputView.printErrorOnRequestBonusNumber()
    }

    private fun readNumbersFromUser() = inputView.readNumbers()

    private fun readNumberFromUser() = inputView.readNumber()

    private fun isControllerOnError() = controllerState == ERROR
}