package lotto.view;

import lotto.model.PlayerLottoNumbers;
import lotto.model.Result;

import java.util.List;

public class OutputView {
    private final String LOTTO_PURCHASED_AMOUNT = "%d개를 구매하셨습니다.\n";
    private final String WINNING_STATISTICS = "당첨 통계\n---\n";

    public void outputPurchasedLottoAmount(int lottoAmount) {
        System.out.printf(LOTTO_PURCHASED_AMOUNT, lottoAmount);
    }

    public void outputPlayerLottoNumbers(PlayerLottoNumbers playerLottoNumbers) {
        for (List<Integer> lotto : playerLottoNumbers.getPlayerLottoNumbers()) {
            System.out.println(lotto.toString());
        }
    }

    public void outputResult(Result matchResult) {
        System.out.println(WINNING_STATISTICS + matchResult.toString());
    }
}
