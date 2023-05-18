package lotto.view;

import lotto.model.PlayerLottoNumbers;
import lotto.model.PlayerLottoNumber;

public class OutputView {
    private enum ConsoleMessage{
        LOTTO_PURCHASED_AMOUNT("%d개를 구매하셨습니다.\n");
        private final String message;
        ConsoleMessage(String message){
            this.message = message;
        }
    }

    public void outputPurchasedLottoAmount(int lottoAmount){
        System.out.printf(ConsoleMessage.LOTTO_PURCHASED_AMOUNT.message, lottoAmount);
    }

    public void outputPlayerLottoNumbers(PlayerLottoNumbers playerLottoNumbers){
        for (PlayerLottoNumber playLottoNumber : playerLottoNumbers.getPlayerLottoNumbers()) {
            System.out.println(playLottoNumber.toString());
        }
    }
}
