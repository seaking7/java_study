package tk.tdd.calc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달뒤가_만료일이_됨(){

        assertExpiryDate(LocalDate.of(2019,3,1), 10000,
                LocalDate.of(2019, 4, 1));
        assertExpiryDate(LocalDate.of(2019,5,5), 10000,
                LocalDate.of(2019, 6, 5));
        assertExpiryDate(LocalDate.of(2019,1,31), 10000,
                LocalDate.of(2019, 2, 28));
        assertExpiryDate(LocalDate.of(2019,5,31), 10000,
                LocalDate.of(2019, 6, 30));
    }

    
    private void assertExpiryDate(LocalDate billingDate, int payAmount, LocalDate resultDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(billingDate, payAmount);

        Assertions.assertThat(expiryDate).isEqualTo(resultDate);
    }
}
