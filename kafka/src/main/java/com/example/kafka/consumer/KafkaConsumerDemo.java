package com.example.kafka.consumer;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaConsumerDemo {

    @KafkaListener(topics = "foo")
    public void demo(ConsumerRecord<Integer, String> record){

        System.out.println("我消费了一条消息"+record.value());


    }



}
