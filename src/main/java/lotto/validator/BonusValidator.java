package lotto.validator;

import lotto.util.ExceptionMessage;

public class BonusValidator {
    public int validatebonus(String bonusNumber){
        validateBonusNumeric(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumeric(String bonusNumber){
        try{
            Integer.parseInt(bonusNumber);
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC.getMessage());
        }
    }
}
