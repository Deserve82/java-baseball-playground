package ui;

import domain.BallCount;

public class OutputView {
    public void printBallCount(BallCount ballCount) {
        StringBuilder sb = new StringBuilder();

        if (ballCount.getBall() != 0) {
            sb.append(ballCount.getBall());
            sb.append("볼 ");
        }

        if (ballCount.getStrike() != 0) {
            sb.append(ballCount.getStrike());
            sb.append("스트라이크");
        }

        if (ballCount.isNothing()) {
            sb.append("낫싱");
        }

        System.out.println(sb.toString());
    }

    public void endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printTypeNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
    }
}
