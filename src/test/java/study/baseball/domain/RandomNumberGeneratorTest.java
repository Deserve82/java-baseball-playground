package study.baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import domain.RandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Test
    @DisplayName("숫자 3자리의 서로 다른 수로 생성 되는 지 확인")
    void testGenerateNumber() {
        String value = randomNumberGenerator.generateRandomNumber();

        assertThat(value).hasSize(3);

        System.out.println(value);
        char first = value.charAt(0);
        char second = value.charAt(1);
        char third = value.charAt(2);
        assertThat(first).isNotEqualTo(second);
        assertThat(second).isNotEqualTo(third);
        assertThat(third).isNotEqualTo(first);
        assertThat(value).containsOnlyDigits();
        assertThat(value).doesNotContain("0");
    }
}
