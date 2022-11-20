package study.generator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import domain.ball.Ball;
import domain.ball.Balls;
import domain.generator.RandomNumberGenerator;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    private RandomNumberGenerator generator = new RandomNumberGenerator(9);

    @Test
    void test_generate_non_duplicate_ball_value() {
        Balls balls = generator.generate();

        for (Ball ball : balls.getBalls()) {
            System.out.print(ball.getValue());
        }
        System.out.println();


        Ball a = balls.getBalls().get(0);
        Ball b = balls.getBalls().get(1);
        Ball c = balls.getBalls().get(2);

        assertThat(a.getValue()).isNotEqualTo(b.getValue());
        assertThat(b.getValue()).isNotEqualTo(c.getValue());
        assertThat(a.getValue()).isNotEqualTo(c.getValue());
    }
}
