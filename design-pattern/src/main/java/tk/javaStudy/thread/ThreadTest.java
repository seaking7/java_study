package tk.javaStudy.thread;

public class ThreadTest{
    public static void main(String[] args) {
        threadTest();
        runnableTest();
    }

    private static void threadTest() {
        System.out.println("thread start");
        MyThread th1 = new MyThread();
        MyThread th2 = new MyThread();

        th1.start();
        th2.start();

        Thread t = Thread.currentThread();
        System.out.println(t);

        System.out.println("thread end");
    }

    private static void runnableTest() {
        System.out.println("runnable start");
        MyThread2 runner1 = new MyThread2();
        Thread th3 = new Thread(runner1);
        th3.start();

        MyThread2 runner2 = new MyThread2();
        Thread th4 = new Thread(runner2);
        th4.start();
        System.out.println("runnable end");
    }
}
