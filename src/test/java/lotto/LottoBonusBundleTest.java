package lotto;

import lotto.model.Bonus;
import lotto.model.Lotto;
import lotto.model.LottoBonusBundle;
import lotto.util.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoBonusBundleTest {

    @DisplayName("당첨번호와 보너스번호가 중복되면 예외를 발생한다.")
    @Test
    void 중복_입력() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Bonus bonus = new Bonus(1);
        assertThatThrownBy(() -> new LottoBonusBundle(lotto, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.DUPLICATE_LOTTO_BONUS.getMessage());
    }
}
