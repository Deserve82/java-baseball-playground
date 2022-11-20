package domain.ball;

public class Ball {

    private final BallPosition position;
    private final BallValue value;

    public Ball(int position, int value) {
        this.position = new BallPosition(position);
        this.value = new BallValue(value);
    }

    public BallStatus compare(Ball counterpart) {
        if (isEqualTo(counterpart)) {
            return BallStatus.STRIKE;
        }

        if (hasSameValue(counterpart)) {
            return BallStatus.BALL;
        }

        return BallStatus.NOTHING;
    }

    public BallStatus compare(Balls counterpart) {
        return counterpart.getBalls()
                .stream().map(ball -> ball.compare(this))
                .filter(ballStatus -> !ballStatus.isNothing())
                .findFirst().orElse(BallStatus.NOTHING);
    }

    public int getValue() {
        return value.getValue();
    }

    public int getPosition() {
        return position.getPosition();
    }

    private boolean hasSameValue(Ball ball) {
        return this.getValue() == ball.getValue();
    }

    private boolean isEqualTo(Ball ball) {
        return (this.getValue() == ball.getValue() && this.getPosition() == ball.getPosition());
    }
}
