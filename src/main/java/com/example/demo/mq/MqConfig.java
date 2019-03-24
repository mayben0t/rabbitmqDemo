package com.example.demo.mq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description:
 * @author: WangX
 * @create: 2019-03-24 20:58
 **/
@Component
@Configuration
public class MqConfig {
    @Value("${spring.rabbitmq.host}")
    private String host;

    @Value("${spring.rabbitmq.port}")
    private String port;


    @Bean
    @Scope("prototype")
    public Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(host);
        factory.setPort(Integer.valueOf(port));
        factory.setVirtualHost("/vh_test");
        factory.setUsername("wangxiao");
        factory.setPassword("test");
        return factory.newConnection();
    }





//    public static Connection getConnection(){
//        ConnectionFactory factory  = new ConnectionFactory();
//
//        factory.setHost(host);
//
//    }
}
