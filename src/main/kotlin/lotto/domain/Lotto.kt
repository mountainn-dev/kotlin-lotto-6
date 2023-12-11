package lotto.domain

import lotto.constants.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(!numbers.map { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }.contains(false))
        require(numbers.distinct().size == numbers.size)
    }

    fun numbers() = numbers

    fun contains(number: Int) = numbers.contains(number)
}
