package domain.Ball;

import java.security.InvalidParameterException;

public class BallPosition {

    private final int position;

    public BallPosition(int position) {

        if (position > 3 || position < 1) {
            throw new InvalidParameterException("잘못 된 위치 값입니다.");
        }

        this.position = position;
    }

    public int getPosition() {
        return position;
    }
}
