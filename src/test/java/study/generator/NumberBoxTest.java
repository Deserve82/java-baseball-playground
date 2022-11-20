package study.generator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import domain.generator.NumberBox;
import org.junit.jupiter.api.Test;

class NumberBoxTest {


    @Test
    void test_number_box_create() {
        assertDoesNotThrow(() -> new NumberBox(9));
    }

    @Test
    void test_pop_number_and_remove() {
        NumberBox box = new NumberBox(3);

        assertThat(box.popNumberAndRemove(0)).isEqualTo(1);
        assertThat(box.getBoxSize()).isEqualTo(2);
    }

}
