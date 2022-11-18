package study.practice;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    void splitTest() {
        String before = "1,2";
        String[] after = before.split(",");
        assertThat(after).contains("1", "2").containsExactly("1", "2");
    }

    @Test
    void splitTest2() {
        String before = "1";
        String[] after = before.split(",");
        assertThat(after).containsExactly("1");
    }

    public String subStringBracket(String str) {
        return str.substring(1, str.length() - 1);
    }

    @Test
    void subStringTest() {
        String before = "(1,2)";
        assertThat(subStringBracket(before)).isEqualTo("1,2");
    }

    @Test
    @DisplayName("abc 값 주어졌을 때에 charAt()으로 특정 문자 가져오기")
    void testCharAt() {
        String before = "abc";
        assertThat(before.charAt(0)).isEqualTo('a');
        assertThat(before.charAt(1)).isEqualTo('b');
        assertThat(before.charAt(2)).isEqualTo('c');
    }

    @Test
    @DisplayName("abc 값 주어졌을 떄에 charAt()으로 특정문자 가져오기, index 에러 발생")
    void testCharAtIndexError() {
        String before = "abc";

        assertThatThrownBy(() -> {
            before.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
