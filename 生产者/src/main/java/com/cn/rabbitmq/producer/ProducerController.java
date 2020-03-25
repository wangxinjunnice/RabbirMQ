package com.cn.rabbitmq.producer;

import com.cn.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@RequestMapping("/test")
public class ProducerController {

    @Autowired
    AmqpTemplate amqpTemplate;

    @GetMapping("/send")
    public void send(){

        List<Map<String,Object>> list=new ArrayList<>();
        Map<String,Object> map=new HashMap<>();
        map.put("name","王飞");
        map.put("age",1000);
        map.put("type",1);
        list.add(map);

        for (int i = 0; i < 100; i++) {
            String message="queue_topic_one收到"+i+"条消息";
            amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE_TOPIC_ONE,message);
//            String mes="queue_topic_two收到"+i+"条消息";
            amqpTemplate.convertAndSend(RabbitmqConfig.QUEUE_TOPIC_TWO,list);

        }
    }
}
