package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.*;

public class PlayerLottoNumber {
    private final List<Integer> playerLottoNumber;

    public PlayerLottoNumber() {
        this.playerLottoNumber = makeLottoNumber();
    }

    private List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }
}