package study.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.ball.BallResult;
import domain.ball.BallStatus;
import org.junit.jupiter.api.Test;

public class BallResultTest {

    @Test
    void test_ball_result_strike() {
        BallResult result = new BallResult();

        result.addValue(BallStatus.STRIKE);

        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void test_ball_result_ball() {
        BallResult result = new BallResult();

        result.addValue(BallStatus.BALL);

        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    void test_ball_result_nothing() {
        BallResult result = new BallResult();

        result.addValue(BallStatus.NOTHING);

        assertThat(result.getBall()).isEqualTo(0);
        assertThat(result.getStrike()).isEqualTo(0);
    }
}
