package domain.Ball;

import java.security.InvalidParameterException;

public class BallValue {
    private final int value;

    public BallValue(int value) {
        if (value > 9 || value < 1) {
            throw new InvalidParameterException("숫자는 9를 넘길 수 없습니다.");
        }

        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

}
