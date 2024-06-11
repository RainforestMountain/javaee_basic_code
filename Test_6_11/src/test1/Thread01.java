package test1;

import test1.Counter;

import java.util.Scanner;

public class Thread01 {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Thread t1 = new Thread(()->{
            while (counter.flag == 0) {
                //do nothing
                //System.out.println(counter.flag);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("循环结束");
        });

        Thread t2 = new Thread(()->{
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入整数");
            counter.flag = scanner.nextInt();
        });

        t1.start();
        t2.start();
    }
}
