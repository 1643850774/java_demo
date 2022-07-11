package com.example.kafka.controller;


import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
public class KafkaProducerSync {

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;


    @GetMapping("/sync")
    public String send() throws ExecutionException, InterruptedException {

        String s = new Date().toString();
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send("foo", 0,s );

            SendResult<Integer, String> futureResult = future.get();

            RecordMetadata metadata = futureResult.getRecordMetadata();
            System.out.println(metadata.offset());



        return "success!";
    }


}
