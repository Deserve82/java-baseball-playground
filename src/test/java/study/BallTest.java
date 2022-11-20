package study;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import domain.Ball.Ball;
import java.security.InvalidParameterException;
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

}
