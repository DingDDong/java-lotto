package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        PlayerLottoNumbers playerLottoNumbers = buyLotto();
        Lotto winningNumber = new Lotto(inputView.inputWinningNumber());
        Bonus bonusNumber = new Bonus(inputView.inputBonusNumber());
        LottoBonusBundle lottoBonusBundle = new LottoBonusBundle(winningNumber, bonusNumber);
    }

    private PlayerLottoNumbers buyLotto() {
        LottoStore lottoAmount = new LottoStore(inputView.inputMoney());
        outputView.outputPurchasedLottoAmount(lottoAmount.getLottoAmount());
        PlayerLottoNumbers playerLottoNumbers = new PlayerLottoNumbers(lottoAmount.getLottoAmount());
        outputView.outputPlayerLottoNumbers(playerLottoNumbers);
        return playerLottoNumbers;
    }
}
