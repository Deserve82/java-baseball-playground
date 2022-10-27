package study;

import java.util.Scanner;

public class StringCalculator {

    private String[] values;

    public void calculate(Scanner scanner) {
        String value = scanner.nextLine();
        values = value.split(" ");

        if (values.length == 0 || values.length % 2 != 1 ) {
            System.out.println("String are not invalid");
        }

        String state;
        int prevNumber = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i ++) {
            if (i % 2 == 0) {
                state = values[i];
            }
        }

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
