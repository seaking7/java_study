package tk.designPattern.strategy.scheduler;

public class PriorityAllocation implements Scheduler{
    @Override
    public void getNextCall() {
        System.out.println("고객 등급이 높은 고객의 전화를 먼저 할당");
    }

    @Override
    public void sendCallToAgent() {
        System.out.println("업무 Skill 값이 높은 상담원");
    }
}
