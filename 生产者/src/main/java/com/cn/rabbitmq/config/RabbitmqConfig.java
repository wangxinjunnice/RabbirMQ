package com.cn.rabbitmq.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitmqConfig {

    //队列
    public static final String QUEUE_TOPIC_ONE="queue_topic_one";
    public static final String QUEUE_TOPIC_TWO="queue_topic_two";

    //交换机
    public static final String EXCHANGE_TOPICS_INFORM="exchange_topics_inform";

    //routingKey
    public static final String ROUTINGKEY_ONE="inform.one";
    public static final String ROUTINGKEY_TWO="inform.two";

    //声明交换机
    @Bean
    public TopicExchange EXCHANGE_TOPICS_INFORM(){
        return new TopicExchange(EXCHANGE_TOPICS_INFORM);
    }

    //声明队列queue_topic_one
    @Bean
    public Queue QUEUE_TOPIC_ONE(){
        return new Queue(QUEUE_TOPIC_ONE);
    }

    //声明队列queue_topic_two
    @Bean
    public Queue QUEUE_TOPIC_TWO(){
        return new Queue(QUEUE_TOPIC_TWO);
    }

    /**
     * destination
     * destinationType
     * exchange
     * routingKey
     * @return
     */
    //队列绑定交换机，指定路由key（routingKey）
    @Bean //QUEUE_TOPIC_ONE
    public Binding BINDING_QUEUE_INFORM_ONE(Queue QUEUE_TOPIC_ONE,Exchange EXCHANGE_TOPICS_INFORM){
    return BindingBuilder.bind(QUEUE_TOPIC_ONE).to(EXCHANGE_TOPICS_INFORM).with(ROUTINGKEY_ONE).noargs();

    }

    @Bean //QUEUE_TOPIC_TWO
    public Binding BINDING_QUEUE_INFORM_TWO(Queue QUEUE_TOPIC_TWO,Exchange EXCHANGE_TOPICS_INFORM){
    return BindingBuilder.bind(QUEUE_TOPIC_TWO).to(EXCHANGE_TOPICS_INFORM).with(ROUTINGKEY_TWO).noargs();

    }

}
