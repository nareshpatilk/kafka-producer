package com.d.kafka.kafkaproducer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.d.kafka.kafkaproducer.model.User;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * 
 * @author Patil
 *
 */
@RestController
@RequestMapping(value = "kafka")
public class UserResource {
	
	
	private static final String TOPIC = "Kafka_Example";
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	
	@GetMapping("/publish/{name}")
	public String publish(@PathVariable("name") final String name) {
		
		kafkaTemplate.send(TOPIC, new User(name, "Tech", 1200l));
		return "Published successfully";
	}

}
