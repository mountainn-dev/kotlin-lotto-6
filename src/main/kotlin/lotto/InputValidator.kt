package lotto

import lotto.constants.Constants

class InputValidator {

    fun isNotBlank(input: String) {
        require(input.isNotBlank())
    }

    fun hasNotBlank(input: String) {
        require(!input.contains(BLANK))
    }

    fun isDigit(input: String) {
        require(!input.map { Character.isDigit(it) }.contains(false))
    }

    fun hasDivider(input: String) {
        require(input.contains(Constants.COMMA))
    }

    companion object {
        private const val BLANK = " "
    }
}