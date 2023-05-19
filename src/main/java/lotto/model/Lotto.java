package lotto.model;

import lotto.util.ExceptionMessage;

import java.util.List;

import static lotto.util.Constants.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try{
            validateSize(numbers);
            validateDuplication(numbers);
            validateRange(numbers);
        }
        catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplication(List<Integer> numbers){
        if (numbers.stream().distinct().count() != LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    private void validateRange(List<Integer> numbers){
        if (numbers.stream().anyMatch(number -> number > LOTTO_RANGE_MAX || number < LOTTO_RANGE_MIN)){
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }
}