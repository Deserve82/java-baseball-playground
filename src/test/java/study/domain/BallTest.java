package study.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.ball.Ball;
import domain.ball.BallStatus;
import domain.ball.Balls;
import java.security.InvalidParameterException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BallTest {

    @Test
    void test_crate_ball() {
        assertDoesNotThrow(() -> new Ball(1, 1));
        assertDoesNotThrow(() -> new Ball(3, 9));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void test_create_ball_invalid_value(int value) {
        assertThrows(InvalidParameterException.class, () -> new Ball(1, value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 4})
    void test_create_ball_invalid_position(int position) {
        assertThrows(InvalidParameterException.class, () -> new Ball(position, 7));
    }

    @Test
    void test_compare_ball_nothing() {
        Ball computer = new Ball(1, 1);
        Ball user = new Ball(1, 2);

        assertThat(computer.compare(user)).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void test_compare_ball_ball() {
        Ball computer = new Ball(1, 1);
        Ball user = new Ball(2, 1);

        assertThat(computer.compare(user)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void test_compare_ball_strike() {
        Ball computer = new Ball(1, 1);
        Ball user = new Ball(1, 1);

        assertThat(computer.compare(user)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void test_compare_balls_strike() {
        Ball computer = new Ball(1, 1);
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(computer.compare(balls)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void test_compare_balls_ball() {
        Ball computer = new Ball(2, 1);
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(computer.compare(balls)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void test_compare_balls_nothing() {
        Ball computer = new Ball(2, 4);
        Balls balls = new Balls(Arrays.asList(1, 2, 3));

        assertThat(computer.compare(balls)).isEqualTo(BallStatus.NOTHING);
    }
}
