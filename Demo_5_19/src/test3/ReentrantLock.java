package test3;

public class ReentrantLock {
    private long holdingThread = -1; // -1表示没有线程持有锁
    private int lockCount = 0;

    public synchronized void lock() {
        long currentThreadId = Thread.currentThread().getId();


        while (holdingThread != currentThreadId && lockCount > 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // 处理线程中断逻辑
            }
        }
        holdingThread = currentThreadId;
        lockCount++;
    }

    public synchronized void unlock() {
        if (Thread.currentThread().getId() == holdingThread) {
            lockCount--;
            if (lockCount == 0) {
                holdingThread = -1; // 没有线程持有锁
                notify();
            }
        }
    }
}
