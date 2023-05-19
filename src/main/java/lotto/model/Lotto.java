package lotto.model;

import lotto.util.ExceptionMessage;

import java.util.List;

import static lotto.util.Constants.LOTTO_NUMBER_COUNT;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        try{
            validateSize(numbers);
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
}

