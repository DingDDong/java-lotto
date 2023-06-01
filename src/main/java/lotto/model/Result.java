package lotto.model;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Result {
    final private LottoBonusBundle lottoBonusBundle;
    final private PlayerLottoNumbers playerLottoNumbers;
    final private Map<Ranking, Integer> rankingInfo = new EnumMap<>(Ranking.class);

    public Result(PlayerLottoNumbers playerLottoNumbers, LottoBonusBundle lottoBonusBundle) {
        this.lottoBonusBundle = lottoBonusBundle;
        this.playerLottoNumbers = playerLottoNumbers;
        calculateResult();
    }

    private void calculateResult() {
        for (PlayerLottoNumber playerLottoNumber : playerLottoNumbers.getPlayerLottoNumbers()) {
            Ranking ranking = Ranking.rankRanking(calculateMatchCount(playerLottoNumber), hasBonusNumber(playerLottoNumber));
            updateRanking(ranking);
        }
    }

    private void updateRanking(Ranking ranking) {
        rankingInfo.put(ranking, rankingInfo.getOrDefault(ranking, 0) + 1);
    }

    private int calculateMatchCount(PlayerLottoNumber playerLottoNumber) {
        List<Integer> temporaryLottoNumber = new ArrayList<>(playerLottoNumber.getPlayerLottoNumber());
        temporaryLottoNumber.retainAll(lottoBonusBundle.getWinningNumber());
        return temporaryLottoNumber.size();
    }

    private boolean hasBonusNumber(PlayerLottoNumber playerLottoNumber) {
        List<Integer> temporaryLottoNumber = playerLottoNumber.getPlayerLottoNumber();
        return temporaryLottoNumber.contains(lottoBonusBundle.getBonusNumber());
    }
}
