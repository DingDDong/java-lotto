package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;
public class LottoStore {
    private final int LottoAmount;

    public LottoStore(int money){
        this.LottoAmount = calculateLottoAmount(money);
    }

    private int calculateLottoAmount(int money){
        return money / LOTTO_PRICE;
    }

    public int getLottoAmount(){
        return LottoAmount;
    }
}
