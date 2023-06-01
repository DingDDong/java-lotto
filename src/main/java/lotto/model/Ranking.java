package lotto.model;

import java.util.Arrays;
import java.util.List;

public enum Ranking {
    FIRST(6, List.of(true, false), 2_000_000_000, "6개 일치"),
    SECOND(5, List.of(true), 30_000_000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, List.of(false), 1_500_000, "5개 일치"),
    FOURTH(4, List.of(true, false), 50_000, "4개 일치"),
    FIFTH(3, List.of(true, false), 5_000, "3개 일치"),
    NONE(1, List.of(true, false), 0, "");

    private final int match;
    private final List<Boolean> hasBonus;
    private final int prize;
    private final String message;

    Ranking(int match, List<Boolean> hasBonus, int prize, String message) {
        this.match = match;
        this.hasBonus = hasBonus;
        this.prize = prize;
        this.message = message;
    }

    public static Ranking rankRanking(int match, boolean hasBonus) {
        return Arrays.stream(Ranking.values())
                .filter(rank -> rank.match == match)
                .filter(rank -> rank.hasBonus.contains(hasBonus))
                .findAny()
                .orElse(NONE);
    }
}