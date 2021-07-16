package com.zxy.bean1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        System.out.println("现在开始初始化容器");

        ApplicationContext factory = new AnnotationConfigApplicationContext("com.zxy.bean1");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Engine engine = factory.getBean("engine01-gbd", Engine.class);
        engine.fire();

        System.out.println("现在开始关闭容器！");
        ((AnnotationConfigApplicationContext) factory).registerShutdownHook();
    }
}
