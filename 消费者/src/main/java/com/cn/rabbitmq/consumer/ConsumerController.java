package com.cn.rabbitmq.consumer;

import com.cn.rabbitmq.config.RabbitmqConfig;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class ConsumerController {

    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE_TOPIC_ONE)
    public void process(String msg){
        System.out.println(msg);
    }

    @RabbitHandler
    @RabbitListener(queues = RabbitmqConfig.QUEUE_TOPIC_TWO)
    public void proces(Object msg){

          System.out.println(msg);

    }

}
