package tk.functional.job;

import com.opencsv.bean.CsvBindByName;


public class PowerConsumption {

    @CsvBindByName(column = "datetime")
    private String useDate;

    @CsvBindByName(column = "Global_active_power")
    private String globalActivePower;

    @CsvBindByName(column = "Global_reactive_power")
    private String globalReactivePower;

    @CsvBindByName(column = "Voltage")
    private String voltage;
    @CsvBindByName(column = "Global_intensity")
    private String globalIntensity;
    @CsvBindByName(column = "Sub_metering_1")
    private String subMeter1;
    @CsvBindByName(column = "Sub_metering_2")
    private String subMeter2;
    @CsvBindByName(column = "Sub_metering_3")
    private String subMeter3;

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public String getGlobalActivePower() {
        return globalActivePower;
    }

    public void setGlobalActivePower(String globalActivePower) {
        this.globalActivePower = globalActivePower;
    }

    public String getGlobalReactivePower() {
        return globalReactivePower;
    }

    public void setGlobalReactivePower(String globalReactivePower) {
        this.globalReactivePower = globalReactivePower;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getGlobalIntensity() {
        return globalIntensity;
    }

    public void setGlobalIntensity(String globalIntensity) {
        this.globalIntensity = globalIntensity;
    }

    public String getSubMeter1() {
        return subMeter1;
    }

    public void setSubMeter1(String subMeter1) {
        this.subMeter1 = subMeter1;
    }

    public String getSubMeter2() {
        return subMeter2;
    }

    public void setSubMeter2(String subMeter2) {
        this.subMeter2 = subMeter2;
    }

    public String getSubMeter3() {
        return subMeter3;
    }

    public void setSubMeter3(String subMeter3) {
        this.subMeter3 = subMeter3;
    }

    @Override
    public String toString() {
        return "PowerConsumption{" +
                "useDate='" + useDate + '\'' +
                ", globalActivePower='" + globalActivePower + '\'' +
                ", globalReactivePower='" + globalReactivePower + '\'' +
                ", voltage='" + voltage + '\'' +
                ", globalIntensity='" + globalIntensity + '\'' +
                ", subMeter1='" + subMeter1 + '\'' +
                ", subMeter2='" + subMeter2 + '\'' +
                ", subMeter3='" + subMeter3 + '\'' +
                '}';
    }
}
