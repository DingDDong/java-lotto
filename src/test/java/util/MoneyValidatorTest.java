package util;

import lotto.util.ExceptionMessage;
import lotto.validator.MoneyValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyValidatorTest {
    private MoneyValidator moneyValidator;

    @BeforeEach
    void SetUp() {
        moneyValidator = new MoneyValidator();
    }

    @Nested
    class InvalidInputTest {

        @DisplayName("입력받은 금액이 자연수가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"한글", " ", " 공백 with 문자", "1000j"})
        void 자연수가_아닌_입력(String input) {
            assertThatThrownBy(() -> moneyValidator.validateMoney(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMERIC.getMessage());
        }

        @DisplayName("입력받은 금액이 1000원 단위가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"5500", "100", "0"})
        void 로또구매_단위가_아닌_입력(String input) {
            assertThatThrownBy(() -> moneyValidator.validateMoney(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_MONEY_PRICE.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @DisplayName("정상값이 들어왔을 경우")
        @ParameterizedTest
        @ValueSource(strings = {"5555000", "1000"})
        void 정상값_입력(String input) {
            assertThatCode(() -> moneyValidator.validateMoney(input))
                    .doesNotThrowAnyException();
        }
    }
}
