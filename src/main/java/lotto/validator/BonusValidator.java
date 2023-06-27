package lotto.validator;

import lotto.util.ExceptionMessage;

import static lotto.util.Constants.LOTTO_RANGE_MAX;
import static lotto.util.Constants.LOTTO_RANGE_MIN;

public class BonusValidator {
    public int validateBonus(String bonusNumber){
        validateBonusNumberNumeric(bonusNumber);
        validateBonusNumberRange(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumberNumeric(String bonusNumber){
        try{
            Integer.parseInt(bonusNumber);
            if (Integer.parseInt(bonusNumber) < 0) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC.getMessage());
            }
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC.getMessage());
        }
    }

    private void validateBonusNumberRange(String bonusNumber) {
        int inputBonus = Integer.parseInt(bonusNumber);
        if (inputBonus > LOTTO_RANGE_MAX ||inputBonus < LOTTO_RANGE_MIN) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }
}
