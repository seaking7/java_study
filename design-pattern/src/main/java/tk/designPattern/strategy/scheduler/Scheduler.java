package tk.designPattern.strategy.scheduler;

public interface Scheduler {
    public void getNextCall();
    public void sendCallToAgent();
}
