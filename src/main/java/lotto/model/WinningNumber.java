package lotto.model;

import lotto.util.ExceptionMessage;

import java.util.List;

import static lotto.util.Constants.LOTTO_NUMBER_COUNT;

public class WinningNumber {
    private final List<Integer> winningNumber;
    private final int bonusNumber;

    public WinningNumber(List<Integer> winningNumber, int bonusNumber) {
        validate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(List<Integer> winningNumber, int bonusNumber) {
        validateSize(winningNumber);
        validateDuplicate(winningNumber);
        validateBonusDuplicate(winningNumber, bonusNumber);
    }

    private void validateBonusDuplicate(List<Integer> winningNumber, int bonusNumber) {
        if (winningNumber.contains(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_BONUS.getMessage());
        }
    }

    private void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

}
