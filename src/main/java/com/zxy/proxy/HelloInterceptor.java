package com.zxy.proxy;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloInterceptor implements MethodInterceptor {
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before..");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println("after..");
        return invoke;
    }
}
