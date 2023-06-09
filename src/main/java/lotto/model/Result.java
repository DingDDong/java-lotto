package lotto.model;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Result {
    final private LottoBonusBundle lottoBonusBundle;
    final private PlayerLottoNumbers playerLottoNumbers;
    final private Map<Ranking, Integer> rankingInfo = new EnumMap<>(Ranking.class);

    public Result(PlayerLottoNumbers playerLottoNumbers, LottoBonusBundle lottoBonusBundle) {
        this.lottoBonusBundle = lottoBonusBundle;
        this.playerLottoNumbers = playerLottoNumbers;
        calculateResult();
        /*for (Map.Entry<Ranking, Integer> entry : rankingInfo.entrySet()) {
            Ranking win = entry.getKey();
            Integer prize = entry.getValue();
            System.out.println(win + ": " + prize);
        }*/
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

    private int getRanking(Ranking ranking) {
        return rankingInfo.getOrDefault(ranking, 0);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("###,###");
        List<Ranking> ranks = Arrays.stream(Ranking.values())
                .filter(rank -> rank != Ranking.NONE)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (Ranking rank : ranks) {
            result.append(
                    String.format("%s (%s원) - %d개\n",
                            rank.getMessage(),
                            df.format(rank.getPrize()),
                            getRanking(rank)));
        }
        return result.toString();
    }
}
