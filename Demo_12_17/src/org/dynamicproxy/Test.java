package org.dynamicproxy;

public class Test {
    public static void main(String[] args) {
        BigStar bigStar = new BigStar("鸡哥");
        Star proxy = ProxyUtil.crateProxy(bigStar);

        String s1 = proxy.sing("只因你太美");
        System.out.println(s1);
        System.out.println("-----------------------");
        String s2 = proxy.dance("只因你太美");
        System.out.println(s2);

    }
}
