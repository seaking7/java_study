package tk.javaStudy.thread;

public class MyThread2 implements Runnable{
    @Override
    public void run() {

        for (int i = 0; i <= 5; i++){
            System.out.print("[r]"+ i + "\t");
            try{
                Thread.sleep(100);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
