package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private enum ConsoleMessage{
        INPUT_MONEY("구입금액을 입력해 주세요."),
        INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");
        private final String message;

        ConsoleMessage(String message){
            this.message = message;
        }
    }

    public int inputMoney(){
        System.out.println(ConsoleMessage.INPUT_MONEY.message);
        String money = Console.readLine();
        return Integer.parseInt(money);
    }
}