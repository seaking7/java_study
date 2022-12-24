package tk.javaStudy.thread;

public class JoinTest extends Thread{

    int start;
    int end;
    int total;

    public JoinTest(int start, int end){
        this.start = start;
        this.end = end;
    }

    public void run(){
        int i = 0;
        for(i = start; i <= end; i++ ){
            total += i;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        JoinTest jt1 = new JoinTest(1, 50);
        JoinTest jt2 = new JoinTest(51, 100);

        jt1.start();
        jt2.start();

        //Main 에서 jt1, jt2에 join 을 건다
        jt1.join();
        jt2.join();

        int total = jt1.total + jt2.total;
        System.out.println("jt1.total = "+ jt1.total );
        System.out.println("jt2.total = "+ jt2.total );
        System.out.println("total = "+ total );
    }
}
