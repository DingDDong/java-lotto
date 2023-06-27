package lotto.validator;

import lotto.util.ExceptionMessage;

import static lotto.util.Constants.LOTTO_PRICE;

public class MoneyValidator {
    public static void validateMoney(String money) {
        validateMoneyNumber(money);
        validateMoneyMultipleOfThousand(money);
        validateMoneyZero(money);
    }

    private static void validateMoneyNumber(String money) {
        try {
            if (Integer.parseInt(money) < 0) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC.getMessage());
        }
    }

    private static void validateMoneyMultipleOfThousand(String money) {
        if (Integer.parseInt(money) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_PRICE.getMessage());
        }
    }

    private static void validateMoneyZero(String money) {
        if ((Integer.parseInt(money)) == 0) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_MONEY_PRICE.getMessage());
        }
    }
}
