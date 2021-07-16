package com.zxy.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UserProxy implements InvocationHandler {
    private User user;

    public UserProxy(User user) {
        this.user = user;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before..");
        Object invoke = method.invoke(user, args);
        System.out.println("after..");
        return invoke;
    }
}
