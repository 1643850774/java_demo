package com.example.kafka.controller;


import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.ExecutionException;

@RestController
public class KafkaProducerAsync {

    @Autowired
    KafkaTemplate<Integer, String> kafkaTemplate;


    @GetMapping("/async")
    public String send() throws ExecutionException, InterruptedException {

        String s = new Date().toString();

        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send("foo", 0, s);


        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {
            @Override
            public void onFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }

            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                System.out.println(result.getRecordMetadata().offset());
            }
        });


        return "success!";
    }


}
