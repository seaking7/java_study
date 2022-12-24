package tk.tdd.calc;

import java.time.LocalDate;

public class ExpiryDateCalculator {

    public LocalDate calculateExpiryDate(PayData paydata) {

        if(paydata.getFirstBillingDate() != null){
            LocalDate candidateExp = paydata.getBillingDate().plusMonths(1);
            if(paydata.getFirstBillingDate().getDayOfMonth() != candidateExp.getDayOfMonth()){
                return candidateExp.withDayOfMonth(paydata.getFirstBillingDate().getDayOfMonth());
            }
        }
        return paydata.getBillingDate().plusMonths(1);
    }
}
