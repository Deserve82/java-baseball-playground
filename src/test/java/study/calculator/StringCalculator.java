package study.calculator;

import java.util.Scanner;

public class StringCalculator {

    private String[] values;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        values = scanner.nextLine().split(" ");
        if (isValidateString()) {
            return;
        }
        calculate();
    }

    public void start(Scanner scanner) {
        String value = scanner.nextLine();
        values = value.split(" ");
        if (isValidateString()) {
            return;
        }
        calculate();
    }

    private boolean isValidateString() {
        if (values.length == 0 || values.length % 2 != 1) {
            System.out.println("test");
            return true;
        }

        return false;
    }

    private void calculate() {
        String state = "";
        int prevNumber = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i++) {
            if (i % 2 == 1) {
                state = values[i];
            } else {
                int currNumber = Integer.parseInt(values[i]);
                switch (state) {
                    case "+":
                        prevNumber = add(prevNumber, currNumber);
                        break;
                    case "-":
                        prevNumber = subtract(prevNumber, currNumber);
                        break;
                    case "*":
                        prevNumber = multiply(prevNumber, currNumber);
                        break;
                    case "/":
                        prevNumber = divide(prevNumber, currNumber);
                        break;
                }
            }
        }
        System.out.println(prevNumber);
    }

    private int add(int a, int b) {
        return a + b;
    }

    private int subtract(int a, int b) {
        return a - b;
    }

    private int multiply(int a, int b) {
        return a * b;
    }

    private int divide(int a, int b) {
        return a / b;
    }
}
