package lotto.domain

enum class WinningRank(private val reward: Int, private val conditionCount: Int, private val bonusCondition: Boolean) {
    FIRST(2000000000, 6, false),
    SECOND(30000000, 5, true),
    THIRD(1500000, 5, false),
    FOURTH(50000, 4, false),
    FIFTH(5000, 3, false),
    NOTHING(0, 0, false);

    fun reward() = reward

    fun conditionCount() = conditionCount

    fun bonusCondition() = bonusCondition
}