package com.zxy.proxy;

import org.junit.Test;
import org.springframework.cglib.proxy.Enhancer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        User user = new UserImpl();
        InvocationHandler proxy = new UserProxy(user);
        User instance = (User) Proxy.newProxyInstance(proxy.getClass().getClassLoader(), user.getClass().getInterfaces(), proxy);
        instance.sayHello();
    }

    @Test
    public void testCGLIBProxy() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(CGUser.class);
        enhancer.setCallback(new HelloInterceptor());
        CGUser cgUser = (CGUser) enhancer.create();
        cgUser.sayHello();

    }
}
