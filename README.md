# 미션 - 로또
1 부터 45 까지의 수로 이루어진 로또를 구매하고 사용자가 직접 추첨하여, 로또 당첨 결과를 출력해주는 프로그램입니다.

## 기능 목록
- [x] 로또를 구매한다.
  - [x] 로또 구입 금액을 입력한다. - MoneyController#set()
    - [x] 값이 올바르지 않은 형태인 경우 예외가 발생하고 에러 메세지가 출력된 후 재입력을 받는다. - InputValidator, LottoMoney
  - [x] 로또 구입 금액만큼 로또를 발행한다. - LottoController#publish()
  - [x] 로또 발행 결과를 출력한다.
    - [x] 로또 구입 개수를 출력한다.
    - [x] 발행된 로또를 오름차순으로 정렬하여 출력한다.
- [x] 로또를 추첨한다.
  - [x] 당첨 번호를 입력한다.
    - [x] 값이 올바르지 않은 형태인 경우 예외가 발생하고 에러 메세지가 출력된 후 재입력을 받는다.
  - [x] 보너스 번호를 입력한다.
    - [x] 값이 올바르지 않은 형태인 경우 예외가 발생하고 에러 메세지가 출력된 후 재입력을 받는다.
- [ ] 당첨 결과를 보여준다.

## 기능 요구 사항
- 로또는 1 부터 45 까지 중복되지 않는 숫자 6 개로 이루어진다.
- 당첨 번호는 1 부터 45 까지 중복되지 않는 숫자 6 개와 보너스 번호 1 개로 이루어진다.
- 로또 1 장의 가격은 1,000 원 이다.
- 당첨 규칙은 다음과 같다.
  - 1등 -> 6 개 번호 일치 (20억)
  - 2등 -> 5 개 번호 일치 + 보너스 번호 일치 (3천만원)
  - 3등 -> 5개 번호 일치 (150만원)
  - 4등 -> 4개 번호 일치 (5만원)
  - 5등 -> 3개 번호 일치 (5천원)

## 예외 상황
사용자가 잘못된 값을 입력한 경우 IllegalArgumentException 이 발생하며, 모든 예외 상황에 대해 예외 처리가 진행되므로
당첨 결과가 출력되기 전까지 프로그램이 종료되지 않아야 합니다.

- 공통
  - 입력값이 공백인 경우
  - 입력값에 공백이 포함된 경우
  - 여러개의 값을 입력하는 경우 구분자 쉼표(,) 가 포함되지 않은 경우
- 로또 구입
  - 입력값이 숫자가 아닌 경우
  - 구입 금액이 0 보다 작거나 같은 경우
  - 구입 금액이 1000 단위로 나누어 떨어지지 않는 경우
- 추첨
  - 당첨 번호
    - 당첨 번호가 숫자가 아닌 경우
    - 당첨 번호가 1 부터 45 까지의 수가 아닌 경우
    - 당첨 번호가 서로 중복되는 경우
    - 당첨 번호의 개수가 6 개가 아닌 경우
  - 보너스 번호
    - 보너스 번호가 숫자가 아닌 경우
    - 보너스 번호가 1 부터 45 까지의 수가 아닌 경우
    - 보너스 번호가 당첨 번호와 중복되는 경우