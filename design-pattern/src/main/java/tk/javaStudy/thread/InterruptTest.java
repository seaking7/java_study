package tk.javaStudy.thread;

public class InterruptTest extends Thread {
    public void run(){

        for(int i = 0; i < 100; i++){
            System.out.println(i);

        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Wake!!");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        InterruptTest test = new InterruptTest();
        test.start();
        test.interrupt();

        System.out.println("end");
    }
}
