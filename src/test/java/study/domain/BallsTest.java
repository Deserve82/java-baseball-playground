package study.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.ball.BallResult;
import domain.ball.Balls;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void test_create_balls() {
        assertDoesNotThrow(() -> new Balls(Arrays.asList(1, 2, 3)));
    }

    @Test
    void test_get_result_value_1() {
        Balls computer = new Balls(Arrays.asList(1, 2, 3));
        Balls user = new Balls(Arrays.asList(3, 4, 5));

        BallResult result = computer.compare(user);
        assertThat(result.getBall()).isEqualTo(1);
        assertThat(result.getStrike()).isEqualTo(0);
    }

    @Test
    void test_get_result_value_2() {
        Balls computer = new Balls(Arrays.asList(3, 5, 4));
        Balls user = new Balls(Arrays.asList(3, 4, 5));

        BallResult result = computer.compare(user);
        assertThat(result.getBall()).isEqualTo(2);
        assertThat(result.getStrike()).isEqualTo(1);
    }

    @Test
    void test_get_result_value_3() {
        Balls computer = new Balls(Arrays.asList(3, 4, 5));
        Balls user = new Balls(Arrays.asList(3, 4, 5));

        BallResult result = computer.compare(user);
        assertThat(result.isEnd()).isTrue();
    }


}
