package lotto.domain

import lotto.constants.Constants

class Winning(private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    init {
        Lotto(winningNumbers)   // 로또 번호 요구 조건을 만족하는지 확인
        require(bonusNumber in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER)
        require(!winningNumbers.contains(bonusNumber))
    }

    fun numbers() = winningNumbers

    fun bonus() = bonusNumber
}