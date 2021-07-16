package com.zxy.test;

import com.zxy.Service.UserService;
import com.zxy.config.ApplicationConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestDoMain {
    public static void main(String[] args) {
        /**
         * 1、register方法中注册了那些bean，这些bean是用来干嘛的？
         * 2、ConfigurationClassPostProcessor、AutowiredAnnotationBeanPostProcessor、
         *          * CommonAnnotationBeanPostProcessor、DefaultEventListenerFactory、EventListenerMethodProcessor的作用
         * ConfigurationClassPostProcessor：处理注解@Configuration，@ComponentScan、@ComponentScans，@Import，@Bean
         * 在configuration类的beanDefinition会进行注解的判断是否存在Lazy，Primary，DependsOn，Role，Description注解
         *
         */
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        UserService service = context.getBean(UserService.class);
        service.getUserAll();
    }

    @Test
    public void testCallable() {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("call..");
                Thread.sleep(1000);
                return 1;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        futureTask.run();
        System.out.println("do something 1..");
        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("do something 2..");
    }

    @Test
    public void testCallable2() {
        Callable<Integer> callable = new Callable<Integer>() {
            public Integer call() throws Exception {
                System.out.println("call..");
                Thread.sleep(1000);
                return 1;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask<Integer>(callable);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println("do something 1..");
        try {
            futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("do something 2..");
    }

    @Test
    public void testProxy() {

    }
}
