package lotto.model;

import lotto.util.ExceptionMessage;

import java.util.List;

public class LottoBonusBundle {
    private final Lotto winningNumber;
    private final Bonus bonusNumber;

    public LottoBonusBundle(Lotto winningNumber, Bonus bonusNumber) {
        validateDuplicate(winningNumber, bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto winningNumber, Bonus bonusNumber) {
        if (winningNumber.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_LOTTO_BONUS.getMessage());
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber.getNumbers();
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }
}
