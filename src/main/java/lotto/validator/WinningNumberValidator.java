package lotto.validator;

import lotto.util.ExceptionMessage;

public class WinningNumberValidator {
    public void validateDelimiter(String winningNumber){
        String delimiter = ",";

        if(!winningNumber.contains(delimiter)){
            throw new IllegalArgumentException(ExceptionMessage.DONT_EXIST_DELIMITER.getMessage());
        }
    }
}
