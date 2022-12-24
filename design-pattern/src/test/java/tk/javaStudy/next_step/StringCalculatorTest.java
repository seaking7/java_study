package tk.javaStudy.next_step;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    private StringCalculator cal;
    @BeforeEach
    void setUp() {
        cal = new StringCalculator();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void add() {
        Assertions.assertThat(cal.add("1,2")).isEqualTo(3);
        Assertions.assertThat(cal.add("1,2,3")).isEqualTo(6);
        Assertions.assertThat(cal.add("1,2:3")).isEqualTo(6);
        Assertions.assertThat(cal.add("//;\n1;2;4")).isEqualTo(7);
        assertThatThrownBy(()-> cal.add("-1,2")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(()-> cal.add("//;\n1;-2;4")).isInstanceOf(RuntimeException.class);
    }
}
