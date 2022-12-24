package tk.designPattern.strategy.scheduler;

public class RoundRobin implements Scheduler{
    @Override
    public void getNextCall() {
        System.out.println("상담전화를 순서대로 대기열에서 가져온다");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("다음 순서 상담원에게 배분합니다");
    }
}
