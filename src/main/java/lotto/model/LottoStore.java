package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.*;

public class LottoStore {
    private final int lottoAmount;

    public LottoStore(int money) {
        this.lottoAmount = calculateLottoAmount(money);
    }

    public static List<Integer> autoMakeLottoNumber() {
        return makeLottoNumber();
    }

    private static List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    private int calculateLottoAmount(int money) {
        return money / LOTTO_PRICE;
    }

    public int getLottoAmount() {
        return lottoAmount;
    }
}
