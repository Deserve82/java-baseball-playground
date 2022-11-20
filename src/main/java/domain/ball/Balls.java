package domain.ball;

import java.util.ArrayList;
import java.util.List;

public class Balls {

    private final List<Ball> balls;

    public Balls(List<Integer> source) {
        balls = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            balls.add(new Ball(i + 1, source.get(i)));
        }
    }

    public BallResult compare(Balls user) {

        BallResult result = new BallResult();

        for (Ball ball : balls) {
            result.addValue(ball.compare(user));
        }

        return result;
    }

    public List<Ball> getBalls() {
        return this.balls;
    }
}
