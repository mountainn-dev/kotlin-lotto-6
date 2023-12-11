package lotto.controller

import lotto.InputView
import lotto.OutputView
import lotto.constants.Constants
import lotto.domain.Lotto
import lotto.domain.Winning
import lotto.domain.WinningRank
import lotto.state.ControllerState.*
import lotto.domain.WinningRank.*

class WinningController {
    private val inputView = InputView()
    private val outputView = OutputView()
    private var controllerState = NORMAL
    private lateinit var winning: Winning
    private lateinit var winningNumbers: List<Int>
    private lateinit var winningResult: List<WinningRank>

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

    fun showResult(userLotto: List<Lotto>) {
        calculateWinning(userLotto)
    }

    private fun calculateWinning(userLotto: List<Lotto>) {
        val result = mutableListOf<WinningRank>()

        userLotto.map {
            result.add(
                calculateWinningRank(calculateWinningNumberCount(it), it.contains(winning.bonus()))
            )
        }

        winningResult = result
    }

    private fun calculateWinningRank(matchCount: Int, hasBonus: Boolean): WinningRank {
        return when (matchCount) {
            FIRST.conditionCount() -> FIRST
            SECOND.conditionCount() -> if (hasBonus) SECOND else THIRD
            FOURTH.conditionCount() -> FOURTH
            FIFTH.conditionCount() -> FIFTH
            else -> NOTHING
        }
    }


    private fun calculateWinningNumberCount(lotto: Lotto): Int {
        var count = 0

        for (i in Constants.ZERO until Constants.LOTTO_NUMBER_COUNT) {
            if (lotto.contains(winning.numbers()[i])) count++
        }

        return count
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