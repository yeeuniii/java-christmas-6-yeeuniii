package christmas;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BadgeTest {
    @DisplayName("헤택 금액 5천원 미만인 경우 없음 출력")
    @ValueSource(ints = {0, 1000, 4999})
    @ParameterizedTest
    void getNoBadge(int totalPrice) {
        String result = Badge.getBadgeNameOfDiscount(totalPrice);

        assertThat(result).isEqualTo("없음");
    }

    @DisplayName("헤택 금액 5천원 이상인 1만원 미만인 경우 별 배지 증정")
    @ValueSource(ints = {5000, 7500, 9999})
    @ParameterizedTest
    void getStarBadge(int totalPrice) {
        String result = Badge.getBadgeNameOfDiscount(totalPrice);

        assertThat(result).isEqualTo("별");
    }

    @DisplayName("헤택 금액 1만원 이상인 2만원 미만인 경우 트리 배지 증정")
    @ValueSource(ints = {10000, 15000, 19999})
    @ParameterizedTest
    void getTreeBadge(int totalPrice) {
        String result = Badge.getBadgeNameOfDiscount(totalPrice);

        assertThat(result).isEqualTo("트리");
    }

    @DisplayName("헤택 금액 2만원 이상인 경우 산타 배지 증정")
    @ValueSource(ints = {20000, 50000, 100000})
    @ParameterizedTest
    void getSantaBadge(int totalPrice) {
        String result = Badge.getBadgeNameOfDiscount(totalPrice);

        assertThat(result).isEqualTo("산타");
    }
}
