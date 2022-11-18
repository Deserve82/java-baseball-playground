package domain;

public class NumberComparer {

    private int strike = 0;
    private int ball = 0;

    private final String computer;
    private final String user;

    public NumberComparer(String computer, String user) {
        this.computer = computer;
        this.user = user;
    }

    public BallCount getBallCount() {
        for (int i = 0; i < 3; i++) {
            countBall(i);
            countStrike(i);
        }
        return new BallCount(strike, ball);
    }

    private void countStrike(int index) {
        if (computer.charAt(index) == user.charAt(index)) {
            strike += 1;
            ball -= 1;
        }
    }

    private void countBall(int index) {
        if (user.contains(String.valueOf(computer.charAt(index)))) {
            ball += 1;
        }
    }

}
