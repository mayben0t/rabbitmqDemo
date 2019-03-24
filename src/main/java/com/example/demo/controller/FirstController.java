package com.example.demo.controller;

import com.example.demo.cosumer.Consumer;
import com.example.demo.producer.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @program: rabbitmq
 * @description:
 * @author: WangX
 * @create: 2019-03-24 21:33
 **/

@RestController
@RequestMapping("/demo")
public class FirstController {

    @Autowired
    private Producer producer;

    @Autowired
    private Consumer consumer;

    @GetMapping("/zz")
    public String test()throws Exception{
        producer.send("xxx");
        return "zz";
    }

    @GetMapping("/zzc")
    public String rte()throws Exception{
        return consumer.process();
    }
}
