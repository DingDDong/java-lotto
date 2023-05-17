package lotto.view;

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
}
