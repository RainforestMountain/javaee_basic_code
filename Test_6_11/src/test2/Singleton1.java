package test2;

public class Singleton1 {
    private static Singleton1 instance = null;

    private Singleton1() {
    }

    public static Singleton1 getInstance() {
        //外层if判断是否为多线程首次调用,确定是否加锁
        if (instance == null) {
            //某一个线程获取锁,加锁,锁对象是Singleton1的class对象
            synchronized (Singleton1.class) {
                //内层if判断是否instance已经被new了,防止其他线程首次调用获取锁后,又new一个instance
                if (instance == null) {
                    instance = new Singleton1();
                }
            }
        }
        return instance;
    }
}
