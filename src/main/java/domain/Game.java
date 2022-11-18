package domain;

import ui.InputView;
import ui.OutputView;

public class Game {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private String computerValue = randomNumberGenerator.generateRandomNumber();

    public int play() {
        int isStop = 0;

        BallCount ballCount = makeBallCount();

        if (ballCount.isEnd()) {
            outputView.endGame();
            isStop = inputView.inputGameOverOrContinue();
        }

        if (isStop == 1) {
            computerValue = randomNumberGenerator.generateRandomNumber();
        }

        return isStop;
    }

    private BallCount makeBallCount() {
        String userValue = getUserValue();
        return compareValue(userValue);
    }

    private String getUserValue() {
        outputView.printTypeNumber();
        return inputView.inputNumber();
    }

    private BallCount compareValue(String userValue) {
        BallCount result = new NumberComparer(computerValue, userValue).getBallCount();
        outputView.printBallCount(result);
        return result;
    }
}
