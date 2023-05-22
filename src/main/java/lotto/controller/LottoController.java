package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.PlayerLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void play() {
        PlayerLottoNumbers playerLottoNumbers = buyLotto();
        Lotto winningNumber = new Lotto(inputView.inputWinningNumber());
        Bonus BonusNumber = new Bonus(inputView.inputBonusNumber());
    }

    private PlayerLottoNumbers buyLotto() {
        LottoStore lottoAmount = new LottoStore(inputView.inputMoney());
        outputView.outputPurchasedLottoAmount(lottoAmount.getLottoAmount());
        PlayerLottoNumbers playerLottoNumbers = new PlayerLottoNumbers(lottoAmount.getLottoAmount());
        outputView.outputPlayerLottoNumbers(playerLottoNumbers);
        return playerLottoNumbers;
    }
}
