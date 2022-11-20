package domain.ball;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }
}
