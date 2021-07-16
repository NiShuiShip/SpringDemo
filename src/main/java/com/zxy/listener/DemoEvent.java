package com.zxy.listener;

import org.springframework.context.ApplicationEvent;

public class DemoEvent extends ApplicationEvent {

    private String str;

    public DemoEvent(String str) {
        super(str);
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
}
