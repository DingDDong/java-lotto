package util;

import lotto.util.ExceptionMessage;
import lotto.validator.WinningNumberValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumberValidatorTest {
    private WinningNumberValidator winningNumberValidator;

    @BeforeEach
    void setUp() {
        winningNumberValidator = new WinningNumberValidator();
    }

    @Nested
    class invalidInput {
        @DisplayName("구분자가 없으면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"123456", "234567", "1.2.3.4.5.6"})
        void 구분자가_없는_경우(String input) {
            assertThatThrownBy(() -> winningNumberValidator.validateWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.DONT_EXIST_DELIMITER.getMessage());
        }

        @DisplayName("당첨 번호가 1부터 45사이의 숫자가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"1,2,3,4,5,46", "-1,24,67,100,150,7777"})
        void 범위를_벗어난_경우(String input) {
            assertThatThrownBy(() -> winningNumberValidator.validateWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMBER_RANGE.getMessage());
        }

        @DisplayName("당첨 번호가 자연수가 아닌 경우에 예외가 발생한다.")
        @ParameterizedTest
        @ValueSource(strings = {"-1,한글,alphabet,-200,-5 500, 한글alphabet 공백 "})
        void 자연수가_아닌_경우(String input) {
            assertThatThrownBy(() -> winningNumberValidator.validateWinningNumber(input))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(ExceptionMessage.INVALID_NUMERIC.getMessage());
        }
    }

    @Nested
    class validInputTest {
        @Test
        void 정상_입력() {
            assertThatCode(() -> winningNumberValidator.validateWinningNumber("1,2,3,4,5,6"))
                    .doesNotThrowAnyException();
        }
    }
}
