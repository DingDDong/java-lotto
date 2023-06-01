package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        PlayerLottoNumbers playerLottoNumbers = buyLotto();
        LottoBonusBundle lottoBonusBundle = receiveWinningNumber();
        makeResult(playerLottoNumbers, lottoBonusBundle);
    }

    private PlayerLottoNumbers buyLotto() {
        LottoStore lottoAmount = new LottoStore(inputView.inputMoney());
        outputView.outputPurchasedLottoAmount(lottoAmount.getLottoAmount());
        PlayerLottoNumbers playerLottoNumbers = new PlayerLottoNumbers(lottoAmount.getLottoAmount());
        outputView.outputPlayerLottoNumbers(playerLottoNumbers);
        return playerLottoNumbers;
    }

    private LottoBonusBundle receiveWinningNumber() {
        Lotto winningNumber = new Lotto(inputView.inputWinningNumber());
        Bonus bonusNumber = new Bonus(inputView.inputBonusNumber());
        return new LottoBonusBundle(winningNumber, bonusNumber);
    }

    private void makeResult(PlayerLottoNumbers playerLottoNumbers, LottoBonusBundle lottoBonusBundle) {
        Result matchResult = new Result(playerLottoNumbers, lottoBonusBundle);
    }
}
