package com.course.kafkaorder.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.kafkaorder.service.KafkaOrderProducer;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	
	private KafkaOrderProducer kafkaOrderProducer;

	public OrderController(KafkaOrderProducer kafkaOrderProducer) {
		super();
		this.kafkaOrderProducer = kafkaOrderProducer;
	}
	
	@PostMapping
	public String sendMessage(@RequestBody Order order) {
			
		order.setOrderId(UUID.randomUUID().toString());
		OrderEvent event = new OrderEvent();
		event.setMessage("Order placed succefully !!");
		event.setStatus("OK");
		event.setOrder(order);
		kafkaOrderProducer.sendMessage(event);
		
		return "Message sent successfully !!!";
	}
}