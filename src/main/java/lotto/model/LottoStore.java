package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.*;

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