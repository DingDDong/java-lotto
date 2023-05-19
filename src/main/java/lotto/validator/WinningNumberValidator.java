package lotto.validator;

import lotto.util.ExceptionMessage;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.util.Constants.LOTTO_RANGE_MAX;
import static lotto.util.Constants.LOTTO_RANGE_MIN;

public class WinningNumberValidator {
    public List<Integer> validateWinningNumber(String winningNumber) {
        List<String> stringWinningNumber = validateDelimiter(winningNumber);
        List<Integer> listWinningNumber = validateNumeric(stringWinningNumber);
        validateRange(listWinningNumber);
        return listWinningNumber;
    }

    private List<String> validateDelimiter(String winningNumber) {
        String delimiter = ",";
        if (!winningNumber.contains(delimiter)) {
            throw new IllegalArgumentException(ExceptionMessage.DONT_EXIST_DELIMITER.getMessage());
        }
        return splitNumberByCommas(winningNumber);
    }

    private List<String> splitNumberByCommas(String inputNumber) {
        String[] winningNumber = inputNumber.replaceAll(" ","").split(",");
        List<String> winningNumberList = Arrays.asList(winningNumber);
        return winningNumberList;
    }

    private void validateRange(List<Integer> winningNumber) {
        if (winningNumber.stream().anyMatch(number -> number > LOTTO_RANGE_MAX || number < LOTTO_RANGE_MIN)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    private List<Integer> validateNumeric(List<String> numbers) {
        try{
            List<Integer> listWinningNumber = numbers.stream()
                    .map(Integer::parseInt)
                    .sorted()
                    .collect(Collectors.toList());
            return listWinningNumber;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMERIC.getMessage());
        }
    }
}
