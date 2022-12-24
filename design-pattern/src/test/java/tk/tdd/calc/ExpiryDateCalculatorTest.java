package tk.tdd.calc;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ExpiryDateCalculatorTest {

    @Test
    void 만원_납부하면_한달뒤가_만료일이_됨(){

        assertExpiryDate(PayData.builder()
                        .firstBillingDate(LocalDate.of(2019,1,30))
                        .billingDate(LocalDate.of(2019, 2, 28))
                        .payAmount(10000)
                        .build(), LocalDate.of(2019, 3, 30));
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 5))
                        .payAmount(10000)
                        .build(), LocalDate.of(2019, 6, 5));
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 1, 31))
                        .payAmount(10000)
                        .build(), LocalDate.of(2019, 2, 28));
        assertExpiryDate(PayData.builder()
                        .billingDate(LocalDate.of(2019, 5, 31))
                        .payAmount(10000)
                        .build(), LocalDate.of(2019, 6, 30));
    }


    private void assertExpiryDate(PayData payData, LocalDate expectedExpiryDate) {
        ExpiryDateCalculator cal = new ExpiryDateCalculator();
        LocalDate expiryDate = cal.calculateExpiryDate(payData);

        Assertions.assertThat(expiryDate).isEqualTo(expectedExpiryDate);
    }
}
