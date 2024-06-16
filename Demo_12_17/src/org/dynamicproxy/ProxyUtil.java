package org.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyUtil {
    public static Star crateProxy(BigStar bigStar) {
        Star proxy = (Star) Proxy.newProxyInstance(ProxyUtil.class.getClassLoader(), new Class[]{Star.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                String methodName = method.getName();
                //代理做的准备工作
                if ("sing".equals(methodName)) {
                    System.out.println("准备话筒，开始收钱");
                } else if ("dance".equals(methodName)) {
                    System.out.println("准备场地，开始收钱");
                }
                //接口中的方法，发生多态,传入method方法的实际调用者和method方法的参数列表
                Object ret = method.invoke(bigStar, args);
                return ret;
            }
        });
        return proxy;
    }
}
