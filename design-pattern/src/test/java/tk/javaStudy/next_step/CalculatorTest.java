package tk.javaStudy.next_step;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    private Calculator cal;

    @BeforeEach
    void setUp() {
        cal = new Calculator();
        System.out.println("before");
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

    @Test
    void add() {
        Assertions.assertThat(cal.add(6,3)).isEqualTo(9);
    }

    @Test
    void subtract() {
        Assertions.assertThat(cal.subtract(6, 3)).isEqualTo(3);
    }

    @Test
    void multiply() {
    }

    @Test
    void divide() {
    }
}
