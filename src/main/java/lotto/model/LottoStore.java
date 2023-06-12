package lotto.model;

import static lotto.util.Constants.LOTTO_PRICE;

public class LottoStore {
    private final int lottoAmount;
    private final int money;

    public LottoStore(int money) {
        this.money = money;
        this.lottoAmount = calculateLottoAmount(money);
    }

    private int calculateLottoAmount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }

    public int getMoney() {
        return money;
    }
}