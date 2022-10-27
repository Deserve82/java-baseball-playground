package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();
    
    @ParameterizedTest
    @CsvSource(value = {"1 1:2"}, delimiter = ':')
    void testCalculate(String input, String output) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        calculator.calculate(scanner);

        System.setOut(System.out);
        outputStream.reset();
    }

}
