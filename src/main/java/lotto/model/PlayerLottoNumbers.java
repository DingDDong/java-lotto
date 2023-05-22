package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PlayerLottoNumbers {
    private final List<PlayerLottoNumber> playerLottoNumbers;

    public PlayerLottoNumbers(int lottoAmount) {
        this.playerLottoNumbers = makeLottoNumbers(lottoAmount);
    }

    private List<PlayerLottoNumber> makeLottoNumbers(int lottoAmount) {
        return Stream.generate(PlayerLottoNumber::autoMakeLottoNumber)
                .limit(lottoAmount)
                .collect(Collectors.toList());
    }

    public List<PlayerLottoNumber> getPlayerLottoNumbers(){
        return playerLottoNumbers;
    }
}