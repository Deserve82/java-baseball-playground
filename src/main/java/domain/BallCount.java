package domain;

public class BallCount {

    private final int strike;
    private final int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public boolean isNothing() {
        return (this.strike == 0 && this.ball == 0);
    }

    public boolean isEnd() {
        return (this.strike == 3);
    }
}
