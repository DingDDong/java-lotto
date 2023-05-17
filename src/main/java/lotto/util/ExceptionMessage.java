package lotto.util;

import static lotto.util.Constants.LOTTO_PRICE;
public enum ExceptionMessage {

    INVALID_MONEY_PRICE(String.format("%d원 단위로 구매 가능합니다.", LOTTO_PRICE));
    private final String message;

    ExceptionMessage(String message) {
        this.message = String.format("[ERROR] %s",message);
    }

    public String getMessage(){
        return message;
    }
}
