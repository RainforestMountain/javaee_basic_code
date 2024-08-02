import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MyExecutor {
    private BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    public void summit(Runnable runnable) throws InterruptedException {
        queue.put(runnable);
    }

    public MyExecutor(int n) {
        for (int i = 0; i < n; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    Runnable runnable = null;
                    try {
                        runnable = queue.take();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    runnable.run();
                }
            });
            t.start();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyExecutor myExecutor = new MyExecutor(10);
        for (int i = 0; i < 1000; i++) {
            int num = i;
            myExecutor.summit(() -> {
                System.out.println("hello" + num + Thread.currentThread().getName());
            });
        }

    }
}
