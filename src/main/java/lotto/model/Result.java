package lotto.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

import static lotto.util.Constants.LOTTO_PRICE;
import static lotto.util.Constants.OUTPUT_REWARD_STATISTIC;

public class Result {
    private final WinningNumber winningNumber;
    private final PlayerLottoNumbers playerLottoNumbers;
    private final Map<Ranking, Integer> rankingInfo = new EnumMap<>(Ranking.class);
    private BigDecimal rewardStatistic = BigDecimal.ZERO;

    public Result(PlayerLottoNumbers playerLottoNumbers, WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
        this.playerLottoNumbers = playerLottoNumbers;
        calculateResult();
        calculateReward();
    }

    private void calculateResult() {
        for (List<Integer> lotto : playerLottoNumbers.getPlayerLottoNumbers()) {
            Ranking ranking = Ranking.rankRanking(calculateMatchCount(lotto), hasBonusNumber(lotto));
            updateRanking(ranking);
        }
    }

    private void updateRanking(Ranking ranking) {
        rankingInfo.put(ranking, rankingInfo.getOrDefault(ranking, 0) + 1);
    }

    private int calculateMatchCount(List<Integer> lotto) {
        List<Integer> temporaryLottoNumber = lotto;
        temporaryLottoNumber.retainAll(winningNumber.getWinningNumber());
        return temporaryLottoNumber.size();
    }

    private boolean hasBonusNumber(List<Integer> lotto) {
        List<Integer> temporaryLottoNumber = lotto;
        return temporaryLottoNumber.contains(winningNumber.getBonusNumber());
    }

    private int getRanking(Ranking ranking) {
        return rankingInfo.getOrDefault(ranking, 0);
    }

    private void calculateReward() {
        BigDecimal totalCashPrize = BigDecimal.ZERO;
        BigDecimal playerMoney = BigDecimal.ZERO;
        for (List<Integer> lotto : playerLottoNumbers.getPlayerLottoNumbers()) {
            Ranking ranking = Ranking.rankRanking(calculateMatchCount(lotto), hasBonusNumber(lotto));
            playerMoney = playerMoney.add(new BigDecimal(String.valueOf(LOTTO_PRICE)));
            totalCashPrize = totalCashPrize.add(new BigDecimal(String.valueOf(ranking.getPrize())));
        }
        rewardStatistic = totalCashPrize.multiply(new BigDecimal(100)).divide(playerMoney, 1, RoundingMode.HALF_EVEN);
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
        result.append(String.format(OUTPUT_REWARD_STATISTIC, rewardStatistic));
        return result.toString();
    }
}
