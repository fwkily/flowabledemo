package com.fwk.flowabledemo.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Classname SpringUtil
 * @Description TODO
 * @Date 2022/11/9 4:04 PM
 * @Created by fuwk
 */
public class SpringUtil implements ApplicationContextInitializer {

    private static ApplicationContext context;

    public static ApplicationContext getContext(){
        return context;
    }

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        context =  applicationContext;
    }

    public static <T> T getBean(Class<T> type){
        return context.getBean(type);
    }


}
