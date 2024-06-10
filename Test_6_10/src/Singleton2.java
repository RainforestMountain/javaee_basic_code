public class Singleton2 {
    //懒汉模式,用synchronized 确保线程安全
    private static Singleton2 instance = null;

    private Singleton2() {
    }

    public synchronized static Singleton2 getInstance() {
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }

}
