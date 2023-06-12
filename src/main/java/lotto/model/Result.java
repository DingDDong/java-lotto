package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import static lotto.util.Constants.LOTTO_PRICE;

public class Result {
    private final LottoBonusBundle lottoBonusBundle;
    private final PlayerLottoNumbers playerLottoNumbers;
    private final Map<Ranking, Integer> rankingInfo = new EnumMap<>(Ranking.class);
    private BigDecimal reward = BigDecimal.ZERO;

    public Result(PlayerLottoNumbers playerLottoNumbers, LottoBonusBundle lottoBonusBundle) {
        this.lottoBonusBundle = lottoBonusBundle;
        this.playerLottoNumbers = playerLottoNumbers;
        calculateResult();
        calculateReward();
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

    private void calculateReward() {
        BigDecimal totalCashPrize = BigDecimal.ZERO;
        BigDecimal playerMoney = BigDecimal.ZERO;
        for (PlayerLottoNumber playerLottoNumber : playerLottoNumbers.getPlayerLottoNumbers()) {
            Ranking ranking = Ranking.rankRanking(calculateMatchCount(playerLottoNumber), hasBonusNumber(playerLottoNumber));
            playerMoney = playerMoney.add(new BigDecimal(String.valueOf(LOTTO_PRICE)));
            totalCashPrize = totalCashPrize.add(new BigDecimal(String.valueOf(ranking.getPrize())));
        }
        reward = totalCashPrize.multiply(new BigDecimal(100)).divide(playerMoney, 1, RoundingMode.HALF_EVEN);
    }

    @Override
    public String toString() {
        DecimalFormat commas = new DecimalFormat("###,###");
        List<Ranking> ranks = Arrays.stream(Ranking.values())
                .filter(rank -> rank != Ranking.NONE)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (Ranking rank : ranks) {
            result.append(
                    String.format("%s (%s원) - %d개\n",
                            rank.getMessage(),
                            commas.format(rank.getPrize()),
                            getRanking(rank)));
        }
        return result.toString();
    }
}
