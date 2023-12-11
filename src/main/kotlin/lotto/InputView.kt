package lotto

import camp.nextstep.edu.missionutils.Console

class InputView {
    private val inputValidator = InputValidator()

    fun readNumber() = validatedNumber(read())

    private fun validatedNumber(input: String): Int {
        inputValidator.isNotBlank(input)
        inputValidator.hasNotBlank(input)
        inputValidator.isDigit(input)

        return Integer.parseInt(input)
    }

    private fun read() = Console.readLine()
}