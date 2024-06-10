public class Test {
    public static void main(String[] args) {
        Singleton1 singleton1_1 = Singleton1.getInstance();
        Singleton1 singleton1_2 = Singleton1.getInstance();
        System.out.println(singleton1_1 == singleton1_2);
//        Singleton1 singleton1_3 = new Singleton1();
        Singleton2 singleton2_1 = Singleton2.getInstance();
        Singleton2 singleton2_2 = Singleton2.getInstance();
        System.out.println(singleton2_1 == singleton2_2);
    }
}
