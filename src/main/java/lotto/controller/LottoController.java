package lotto.controller;

import lotto.model.LottoStore;
import lotto.model.PlayerLottoNumbers;
import lotto.model.Result;
import lotto.model.WinningNumber;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        PlayerLottoNumbers playerLottoNumbers = buyLotto();
        WinningNumber lottoBonusBundle = receiveWinningNumber();
        makeResult(playerLottoNumbers, lottoBonusBundle);
    }

    private PlayerLottoNumbers buyLotto() {
        LottoStore lottoAmount = new LottoStore(inputView.inputMoney());
        outputView.outputPurchasedLottoAmount(lottoAmount.getLottoAmount());
        PlayerLottoNumbers playerLottoNumbers = new PlayerLottoNumbers(lottoAmount.getLottoAmount());
        outputView.outputPlayerLottoNumbers(playerLottoNumbers);
        return playerLottoNumbers;
    }

    private WinningNumber receiveWinningNumber() {
        WinningNumber winningNumber = new WinningNumber(inputView.inputWinningNumber(), inputView.inputBonusNumber());
        return winningNumber;
    }

    private void makeResult(PlayerLottoNumbers playerLottoNumbers, WinningNumber winningNumber) {
        Result matchResult = new Result(playerLottoNumbers, winningNumber);
        outputView.outputResult(matchResult);
    }
}
