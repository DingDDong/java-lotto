package util;

import lotto.util.ExceptionMessage;
import lotto.validator.BonusValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusValidatorTest {
    private BonusValidator bonusValidator;

    @BeforeEach
    void setUp() {
        bonusValidator = new BonusValidator();
    }

    @Nested
    class invalidInputTest {

        @DisplayName("보너스 번호로 자연수가 입력되지 않으면 예외를 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1", "한글", "alphabet", "한글 with 공백   "})
        void 자연수가_아닌_경우(String input) {
            assertThatThrownBy(() -> bonusValidator.validateBonus(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMERIC.getMessage());
        }

        @DisplayName("1부터 45까지의 범위를 벗어나면 예외를 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"0", "100", "5500"})
        void 범위를_벗어난_경우(String input) {
            assertThatThrownBy(() -> bonusValidator.validateBonus(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }
    }

    @Nested
    class validInputTest {

        @ParameterizedTest
        @ValueSource(strings = {"1", "45"})
        void 정상_입력(String input) {
            assertThatCode(() -> bonusValidator.validateBonus(input))
                    .doesNotThrowAnyException();
        }
    }
}
