package tk.functional.job;

public class ModifyConsumption {

    private String useDate;

    private Double globalActivePower;

    private Double globalReactivePower;

    private Double voltage;

    private Double globalIntensity;

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public Double getGlobalActivePower() {
        return globalActivePower;
    }

    public void setGlobalActivePower(Double globalActivePower) {
        this.globalActivePower = globalActivePower;
    }

    public Double getGlobalReactivePower() {
        return globalReactivePower;
    }

    public void setGlobalReactivePower(Double globalReactivePower) {
        this.globalReactivePower = globalReactivePower;
    }

    public Double getVoltage() {
        return voltage;
    }

    public void setVoltage(Double voltage) {
        this.voltage = voltage;
    }

    public Double getGlobalIntensity() {
        return globalIntensity;
    }

    public void setGlobalIntensity(Double globalIntensity) {
        this.globalIntensity = globalIntensity;
    }

    @Override
    public String toString() {
        return "ModifyConsumption{" +
                "useDate='" + useDate + '\'' +
                ", globalActivePower=" + globalActivePower +
                ", globalReactivePower=" + globalReactivePower +
                ", voltage=" + voltage +
                ", globalIntensity=" + globalIntensity +
                '}';
    }
}
