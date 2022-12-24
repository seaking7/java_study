package tk.refactoring._10_data_clumps;

public class TelephoneNumber {

    private String AreaCode;

    private String Number;

    public TelephoneNumber(String areaCode, String number) {
        AreaCode = areaCode;
        Number = number;
    }

    @Override
    public String toString() {
        return AreaCode + '-' + Number ;
    }
}
