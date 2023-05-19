package lotto.model;

public class Bonus {
    private final int bonusNumber;

    private Bonus(int bonusNumber){
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber(){
        return bonusNumber;
    }
}
