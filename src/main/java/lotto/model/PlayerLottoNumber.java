package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.util.Constants.*;

public class PlayerLottoNumber {
    private final List<Integer> playerLottoNumber;

    private PlayerLottoNumber() {
        this.playerLottoNumber = makeLottoNumber();
    }

    public static PlayerLottoNumber autoMakeLottoNumber() {
        return new PlayerLottoNumber();
    }

    private List<Integer> makeLottoNumber() {
        List<Integer> lottoNumber = Randoms.pickUniqueNumbersInRange(LOTTO_RANGE_MIN, LOTTO_RANGE_MAX, LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumber);
        return lottoNumber;
    }

    @Override
    public String toString() {
        return playerLottoNumber.toString();
    }
}