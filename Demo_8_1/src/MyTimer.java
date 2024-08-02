import java.util.PriorityQueue;

public class MyTimer {

    private PriorityQueue<MyTask> myTaskPriorityQueue = new PriorityQueue<>();

    private Object locker = new Object();

    public void schedule(Runnable command, long after) {
        synchronized (locker) {
            MyTask task = new MyTask(command, after);
            myTaskPriorityQueue.offer(task);
            locker.notify();
        }
    }

    public MyTimer() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    synchronized (locker) {
                        while (myTaskPriorityQueue.size() == 0) {
                            locker.wait();
                        }
                        MyTask task = myTaskPriorityQueue.peek();
                        long curTime = System.currentTimeMillis();
                        if (curTime >= task.time) {
                            myTaskPriorityQueue.poll();
                            task.runnable.run();
                        } else {
                            locker.wait(task.time - curTime);
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    public static void main(String[] args) {
        MyTimer timer = new MyTimer();
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 3000");
            }
        }, 3000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 2000");
            }
        }, 2000);
        timer.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello 1000");
            }
        }, 1000);
    }
}

class MyTask implements Comparable<MyTask> {
    public Runnable runnable;
    public long time;

    public MyTask(Runnable runnable, long delay) {
        this.runnable = runnable;
        this.time = System.currentTimeMillis() + delay;
    }

    @Override
    public int compareTo(MyTask o) {
        return (int) (this.time - o.time);
    }
}
