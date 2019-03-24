package com.example.demo.cosumer;

import com.rabbitmq.client.*;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @program: rabbitmq
 * @description:
 * @author: WangX
 * @create: 2019-03-24 23:09
 **/
@Component
//@RabbitListener(queues = "呜呜呜")
public class Consumer {
    @Autowired
    private Connection connection;

//   @RabbitHandler
    public String process() throws Exception {
        Channel channel = connection.createChannel();
        //队列声明
        channel.queueDeclare("呜呜呜",false,false,false,null);

        DefaultConsumer consumer=new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf8");
                System.out.println(msg);
            }
        };
        channel.basicConsume("呜呜呜",true,consumer);
        return "success";
    }
}
