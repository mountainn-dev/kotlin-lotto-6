package lotto.constants

object Exception {
    const val ERROR_REQUEST_MONEY = "구입 금액은 0 보다 크고 1000 단위로 나누어 떨어지는 수여야 합니다. 다시 입력해주세요"
    const val ERROR_REQUEST_WINNING_NUMBERS = "당첨 번호는 1 부터 45 까지 서로 중복되지 않는 6 개의 수여야 합니다."
    const val ERROR_REQUEST_BONUS_NUMBER = "보너스 번호는 당첨 번호와 중복되지 않는 1 부터 45 까지의 수여야 합니다."
}