import domain.ball.BallResult;
import domain.ball.Balls;
import domain.generator.RandomNumberGenerator;
import ui.InputView;
import ui.OutputView;

public class BaseBallGame {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    private static Balls computer;
    private static Balls user;


    public static void main(String[] args) {

        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator(9);

        user = getNumberFromUser();
        computer = randomNumberGenerator.generate();

        BallResult result = compareAndPrintResult();

        boolean stop = false;
        while (!stop) {
            user = getNumberFromUser();
            result = compareAndPrintResult();
            stop = checkGameContinueOrNot(result);
        }
    }

    private static boolean checkGameContinueOrNot(BallResult result) {
        if (result.isEnd()) {
            outputView.endGame();
            int value = inputView.inputGameOverOrContinue();
            return restartOrNot(value);
        }
        return false;
    }

    private static BallResult compareAndPrintResult() {
        BallResult result = computer.compare(user);
        outputView.printBallCount(result);
        return result;
    }

    private static Balls getNumberFromUser() {
        outputView.printTypeNumber();
        return new Balls(inputView.inputNumber());
    }

    private static boolean restartOrNot(int value) {
        if (value == 1) {
            computer = new RandomNumberGenerator(9).generate();
            return false;
        }
        return true;
    }
}
