package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.constants.Constants

class InputView {
    private val inputValidator = InputValidator()

    fun readNumber() = validatedNumber(read())

    fun readNumbers() = validatedNumbers(read())

    private fun validatedNumber(input: String): Int {
        inputValidator.isNotBlank(input)
        inputValidator.hasNotBlank(input)
        inputValidator.isDigit(input)

        return Integer.parseInt(input)
    }

    private fun validatedNumbers(input: String): List<Int> {
        inputValidator.isNotBlank(input)
        inputValidator.hasNotBlank(input)
        inputValidator.hasDivider(input)
        input.split(Constants.COMMA).map { inputValidator.isDigit(it) }

        return input.split(Constants.COMMA).map { it.toInt() }
    }

    private fun read() = Console.readLine()
}