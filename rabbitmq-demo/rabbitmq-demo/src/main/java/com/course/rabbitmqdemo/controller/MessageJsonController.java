package com.course.rabbitmqdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.rabbitmqdemo.dto.User;
import com.course.rabbitmqdemo.publisher.RabbitMQJsonProducer;


@RestController
@RequestMapping("/mq1")
public class MessageJsonController {

	@Autowired
	private RabbitMQJsonProducer jsonProducer;
	

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        jsonProducer.sendJsonMessage(user);
        return ResponseEntity.ok("Json message sent to RabbitMQ ...");
    }
}