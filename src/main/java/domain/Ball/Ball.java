package domain.Ball;

public class Ball {

    private final BallPosition position;
    private final BallValue value;

    public Ball(int position, int value) {
        this.position = new BallPosition(position);
        this.value = new BallValue(value);
    }
}
