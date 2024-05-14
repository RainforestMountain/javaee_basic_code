public class ThreadTest1 {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new MyThread();
        Thread runnable = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("hello runnable");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        myThread.start();
        runnable.start();
        while (true) {
            System.out.println("hello main");
            Thread.sleep(5000);
        }
    }

}

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("hello mythread");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }
}
