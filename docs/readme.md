# 기능 목록 구현
- [ ] lotto 전체적인 진행을 다루는 클래스 - LottoController

- [x] "구입 금액을 입력해 주세요." 메세지 출력 후 입력 받는 기능 - inputMoney
  - [x] (e) 숫자가 아니면 예외처리 - validateMoneyNumber
  - [x] (e) 1000의 배수가 아니면 예외처리 - validateMoneyMultipleOfThousand
  - [x] (e) 빈 값이면 예외처리 - validateMoneyNumber
  - [x] (e) 음수 예외처리 - validateMoneyNumber
  - [x] (e) 받은 금액이 0원일때 예외처리 - validateMoneyZero

- [x] 구매가능한 로또의 갯수를 반환해주는 기능 - calculateLottoAmount
- [x] "n개를 구매했습니다." 출력하는 기능- outputPurchasedLottoAmount

- [ ] 로또 번호와 관련된 기능 - Lotto
  - [x] 로또 번호를 생성하는 기능 - makeLottoNumber
  - [x] 생성된 로또 번호를 오름차순으로 정렬하는 기능 - Collections.sort
  - [x] 여러개의 로또를 List에 저장하는 기능 
  - [x] 로또번호를 출력하는 기능 - outputLottoNumber


- [x] 당첨 번호를 입력받는 기능 - inputWinningNumber
  - [x] 당첨 번호를 (,)를 기준으로 구분하는 기능 - splitNumberByCommas
    - [x] (e)구분자가 없으면 예외처리 -validateDelimiter
  - [x] (e)구분된 숫자가 6개가 아니면 예외처리 - validateSize
  - [x] (e) 중복이 있으면 예외처리 - validateWinningNumberDistinct
  - [x] (e) 범위를 벗어나면 예외처리  - validateWinningNumberRange
  - [x] (e) 숫자가 아니면 예외처리 - validateWinningNumberNumber
  
- [ ] 보너스 번호를 입력받는 기능 - inputBonusNumber 
  - [ ] (e) 중복이 있으면 예외처피 - validateBonusNumberDistinct
  - [ ] (e) 숫자가 아니면 예외처리 - validateBonusNumberNumber
  - [ ] (e) 범위를 벗어났으면 예외처리 - validateBonusNumberRange

- [ ] 로또 번호와 당첨 번호 등수 확인 기능 - matchNumber

- [ ] 수익률 계산하는 기능 - calculateYield
  - [ ] 수익률은 소수점 둘째 자리에서 반올림한다.
          
- [ ] 통계를 출력하는 기능 - outputResult
          
- [ ] 수익률 출력하는 기능 - outputYield


 