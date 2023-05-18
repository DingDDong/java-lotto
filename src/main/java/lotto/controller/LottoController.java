package lotto.controller;

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
        int money = inputView.inputMoney();
        LottoStore lottoStore = new LottoStore(money);
        outputView.outputPurchasedLottoAmount(lottoStore.getLottoAmount());
        PlayerLottoNumbers playerLottoNumbers = new PlayerLottoNumbers(lottoStore.getLottoAmount());
        outputView.outputPlayerLottoNumbers(playerLottoNumbers);
    }
}
