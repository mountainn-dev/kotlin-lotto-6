package lotto

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

    companion object {
        private const val BLANK = " "
    }
}