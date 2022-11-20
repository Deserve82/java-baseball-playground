package domain.ball;

public class BallResult {

    private int ball = 0;
    private int strike = 0;

    public void addValue(BallStatus status) {
        if (status.isStrike()) {
            strike += 1;
        }

        if (status.isBall()) {
            ball += 1;
        }
    }

    public boolean isEnd() {
        return this.strike == 3;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

}
