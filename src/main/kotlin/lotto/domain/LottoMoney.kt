package lotto.domain

import lotto.constants.Constants

class LottoMoney(private val money: Int) {

    init {
        require(money > Constants.ZERO)
        require(money % Constants.THOUSAND == Constants.ZERO)
    }

    fun availableLottoCount() = money / Constants.THOUSAND
}