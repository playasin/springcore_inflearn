package com.hello.core.beanfind;

import com.hello.springcore.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beans =  applicationContext.getBeanDefinitionNames();

        for (String beanName : beans) {
            Object bean = applicationContext.getBean(beanName);
            System.out.println("bean name = " + beanName + ", object = " + bean);
        }
    }
}
