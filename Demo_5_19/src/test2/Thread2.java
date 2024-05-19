package test2;

class Counter {
    int count = 0;

    public void add() {
        for (int i = 0; i < 50000; i++) {
            synchronized (this) {
                count++;
            }
        }
    }

    static Counter counter = new Counter();

    public /*synchronized*/ static void func() {

        for (int i = 0; i < 50000; i++) {
            counter.count++;
        }
    }
}

public class Thread2 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Counter counter2 = new Counter();
//        Thread t1 = new Thread(() -> {
//            synchronized (counter) {
//                counter.add();
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            synchronized (counter) {
//                counter.add();
//            }
//        });
//        Thread t1 = new Thread(() -> {
//            counter.add();
//        });
//
//        Thread t2 = new Thread(() -> {
//            counter.add();
//        });

        Thread t1 = new Thread(() -> {
            counter.func();
        });

        Thread t2 = new Thread(() -> {
            counter.func();
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(counter.counter.count);
    }
}
