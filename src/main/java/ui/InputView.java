package ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    Scanner sc = new Scanner(System.in);

    public List<Integer> inputNumber() {
        return Arrays.stream(sc.next().split("")).map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public int inputGameOverOrContinue() {
        return sc.nextInt();
    }
}