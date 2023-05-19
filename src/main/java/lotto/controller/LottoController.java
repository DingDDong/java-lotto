package lotto.controller;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.PlayerLottoNumber;
import lotto.model.PlayerLottoNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    public void play(){
        PlayerLottoNumbers playerLottoNumbers = buyLotto();
        Lotto winningNumber = new Lotto(inputView.inputWinningNumber());
        Bonus BonusNumber = new Bonus(inputView.inputBonusNumber());
    }

    private PlayerLottoNumbers buyLotto(){
        LottoStore lottoStore = new LottoStore(inputView.inputMoney());
        outputView.outputPurchasedLottoAmount(lottoStore.getLottoAmount());
        PlayerLottoNumbers playerLottoNumbers = new PlayerLottoNumbers(lottoStore.getLottoAmount());
        outputView.outputPlayerLottoNumbers(playerLottoNumbers);
        return playerLottoNumbers;
    }
}
