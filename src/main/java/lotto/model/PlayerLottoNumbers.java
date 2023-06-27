package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerLottoNumbers {
    private final List<List<Integer>> playerLottoNumbers;

    public PlayerLottoNumbers(int lottoAmount) {
        this.playerLottoNumbers = makeLottoNumbers(lottoAmount);
    }

    private List<List<Integer>> makeLottoNumbers(int lottoAmount) {
        return Stream.generate(LottoStore::autoMakeLottoNumber)
                .limit(lottoAmount)
                .collect(Collectors.toList());
    }

    public List<List<Integer>> getPlayerLottoNumbers() {
        return Collections.unmodifiableList(playerLottoNumbers);
    }
}
