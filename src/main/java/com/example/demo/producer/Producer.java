package com.example.demo.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @program: rabbitmq
 * @description:
 * @author: WangX
 * @create: 2019-03-24 21:30
 **/
@Service
public class Producer {

    @Autowired
    private Connection connection;

    private static final String QUEUE_NAME = "呜呜呜";

    public void send(String test) throws IOException, TimeoutException {
        Channel channel = connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);
        channel.basicPublish("",QUEUE_NAME,null,"我笑了".getBytes());
        channel.close();
        connection.close();
    }
}
