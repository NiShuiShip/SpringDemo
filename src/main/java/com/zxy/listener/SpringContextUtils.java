package com.zxy.listener;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;

public class SpringContextUtils implements ApplicationContextAware, DisposableBean {
    private static ApplicationContext applicationContext = null;
    public void destroy() throws Exception {
        applicationContext = null;
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtils.applicationContext = applicationContext;
    }

    public static void publishEvent(ApplicationEvent event) {
        applicationContext.publishEvent(event);
    }
}
