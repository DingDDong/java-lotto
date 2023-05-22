package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.BonusValidator;
import lotto.validator.MoneyValidator;
import lotto.validator.WinningNumberValidator;

import java.util.List;


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
        new MoneyValidator().validateMoney(money);
        return Integer.parseInt(money);
    }

    public List<Integer> inputWinningNumber(){
        WinningNumberValidator winningNumberValidator = new WinningNumberValidator();
        System.out.println(ConsoleMessage.INPUT_WINNING_NUMBER.message);
        String winningNumber = Console.readLine();
        return winningNumberValidator.validateWinningNumber(winningNumber);
    }

    public int inputBonusNumber(){
        BonusValidator bonusValidator = new BonusValidator();
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.message);
        String bonusNumber = Console.readLine();
        return bonusValidator.validateBonus(bonusNumber);
    }
}
