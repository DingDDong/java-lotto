package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;
public enum ExceptionMessage {

    INVALID_MONEY_PRICE(String.format("%d원 단위로 구매 가능합니다.", LOTTO_PRICE)),
    INVALID_NUMERIC("자연수만 입력 가능합니다."),
    DONT_EXIST_DELIMITER("구분자가 존재하지 않습니다."),
    INVALID_LOTTO_SIZE("6개의 숫자가 입력되지 않았습니다."),
    INVALID_NUMBER_RANGE("1에서 45사이의 숫자만 입력 가능합니다."),
    DUPLICATE_LOTTO_NUMBER("중복된 숫자가 포함되어 있습니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format("[ERROR] %s",message);
    }

    public String getMessage(){
        return message;
    }
}
