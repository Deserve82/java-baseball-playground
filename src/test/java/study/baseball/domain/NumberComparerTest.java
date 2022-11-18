package study.baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.BallCount;
import domain.NumberComparer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class NumberComparerTest {

    @ParameterizedTest
    @CsvSource(value = {"482:3", "412:2", "562:1", "123:0", "987:1", "123:0"}, delimiter = ':')
    @DisplayName("숫자 두개를 비교해서 BallCount 객체를 반환한다 - strike 개수 확인")
    void testCompareCountStrike(String input, int output) {
        NumberComparer numberComparer = new NumberComparer("482", input);

        BallCount result = numberComparer.getBallCount();
        assertThat(result.getStrike()).isEqualTo(output);
    }

    @ParameterizedTest
    @CsvSource(value = {"482:0", "412:0", "562:0", "123:1", "987:0", "123:1", "248:3", "287:1",
            "241:2"}, delimiter = ':')
    @DisplayName("숫자 두개를 비교해서 BallCount 객체를 반환한다 - strike 개수 확인")
    void testCompareCountBall(String input, int output) {
        NumberComparer numberComparer = new NumberComparer("482", input);

        BallCount result = numberComparer.getBallCount();
        assertThat(result.getBall()).isEqualTo(output);
    }
}
