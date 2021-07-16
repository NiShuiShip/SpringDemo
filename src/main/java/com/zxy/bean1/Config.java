package com.zxy.bean1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    SpecialBeanForEngine specialBeanForEngine() {
        return new SpecialBeanForEngine();
    }

    @Bean(initMethod = "start")
    BenzCar benzCar(Engine engine) {
        BenzCar car = new BenzCar();
        car.engine = engine;
        return car;
    }

}
