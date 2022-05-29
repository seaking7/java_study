package tk.refactoring._07_divergent_change._26_extract_class;

public class TelephoneNumber {
    String areaCode;
    String number;

    public TelephoneNumber() {
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return areaCode + " " + number;
    }
}