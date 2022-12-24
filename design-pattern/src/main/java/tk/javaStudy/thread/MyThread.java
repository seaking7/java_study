package tk.javaStudy.thread;

class MyThread extends Thread {

    public void run() {

        for (int i = 0; i <= 5; i++) {
            System.out.print("[t]" + i + "\t");
            try {
                sleep(100);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
