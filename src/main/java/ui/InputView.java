package ui;

import java.util.Scanner;

public class InputView {

    Scanner sc = new Scanner(System.in);

    public String inputNumber() {
        return sc.next();
    }

    public int inputGameOverOrContinue() {
        return sc.nextInt();
    }
}