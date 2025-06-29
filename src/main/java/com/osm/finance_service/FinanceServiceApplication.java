package com.osm.finance_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableFeignClients(basePackages = {"com.xdev.communicator", "com.osm.finance_service","com.xdev","com.xdev.xdevsecurity"})
@ComponentScan(basePackages = {"com.xdev", "com.xdev.xdevsecurity","com.xdev.xdevbase","com.xdev.communicator", "com.osm.finance_service"})
@EnableJpaRepositories(basePackages = {"com.xdev", "com.xdev.xdevbase", "com.osm.finance_service"}, repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
public class FinanceServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanceServiceApplication.class, args);
    }

}
