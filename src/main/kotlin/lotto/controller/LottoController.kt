package lotto.controller

import lotto.OutputView
import lotto.constants.Constants
import lotto.domain.Lotto
import camp.nextstep.edu.missionutils.Randoms

class LottoController {
    private val outputView = OutputView()
    private lateinit var userLotto: List<Lotto>

    fun get() = userLotto

    fun publish(count: Int) {
        publishLottoAsMuchAsCount(count)
        showResult()
    }

    private fun publishLottoAsMuchAsCount(count: Int) {
        val lotto = mutableListOf<Lotto>()

        for (i in Constants.ZERO until count) {
            lotto.add(generatedLotto())
        }

        userLotto = lotto
    }

    private fun showResult() {
        outputView.printResultPublish(userLotto)
    }

    private fun generatedLotto() = Lotto(generatedLottoNumbers())

    private fun generatedLottoNumbers() = Randoms.pickUniqueNumbersInRange(
        Constants.MIN_LOTTO_NUMBER,
        Constants.MAX_LOTTO_NUMBER,
        Constants.LOTTO_NUMBER_COUNT
    )
}