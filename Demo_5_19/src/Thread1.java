public class Thread1 {
    static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Object locker = new Object();
        Object locker2 = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    synchronized (locker) {
                        count++;
                    }

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50000; i++) {
                    synchronized (locker2) {
                        count++;
                    }
                }
            }
        });
        t1.start();

        t1.join();
        t2.start();
        t2.join();
        System.out.println(count);
    }
}
