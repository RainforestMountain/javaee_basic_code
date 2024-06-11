package test2;

public class Thread01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            Singleton1 s1 = Singleton1.getInstance();
            System.out.println(s1);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            Singleton1 s2 = Singleton1.getInstance();
            System.out.println(s2);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        long time1 = System.currentTimeMillis();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
        System.out.println("main结束");
    }
}
