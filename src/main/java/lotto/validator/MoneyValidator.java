package lotto.validator;

import static lotto.util.Constants.LOTTO_PRICE;
import lotto.util.ExceptionMessage;

public class MoneyValidator {
    public void validateMoney(String money){
        validateMoneyMultipleOfThousand(money);
    }

    private void validateMoneyMultipleOfThousand(String money){
        if(Integer.parseInt(money) % LOTTO_PRICE != 0){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_PRICE.getMessage());
        }
    }
}
