package study;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();
    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    @BeforeEach
    void init() {
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void reset() {
        System.setOut(System.out);
        outputStream.reset();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 1:2", "100 * 100:10000", "10 / 2:5", "5 - 2:3", "10 + 2 - 4 / 2 * 100:400"}, delimiter = ':')
    void testCalculate(String input, String output) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        calculator.start(scanner);

        assertThat(outputStream).hasToString(output +"\n");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + "})
    void testCalculateInvalidException(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        calculator.start(scanner);

        assertThat(outputStream).hasToString("test\n");
    }

}
