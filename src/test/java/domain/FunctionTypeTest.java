package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class FunctionTypeTest {
    @DisplayName("입력한 값이 유효한 기능인지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void getFunctionTypeTest(int input) {
        FunctionType functionType = FunctionType.getFunctionType(input);

        Assertions.assertThat(functionType).isInstanceOf(FunctionType.class);
    }

    @DisplayName("유효하지 않은 결제 수단을 입력했을 때 예외 출력 테스트")
    @Test
    void getFunctionTypeWithInvalidInput() {
        Assertions.assertThatThrownBy(() -> {
            FunctionType functionType = FunctionType.getFunctionType(4);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
