package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;
public enum ExceptionMessage {

    INVALID_MONEY_PRICE(String.format("%d원 단위로 구매 가능합니다.", LOTTO_PRICE)),
    INVALID_MONEY_NUMBER("자연수만 입력 가능합니다."),
    DONT_EXIST_DELIMITER("구분자가 존재하지 않습니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format("[ERROR] %s",message);
    }

    public String getMessage(){
        return message;
    }
}
