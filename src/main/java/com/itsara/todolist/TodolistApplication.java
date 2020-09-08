package com.itsara.todolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}

	@RequestMapping(value = "/tasks", method = RequestMethod.GET)
	public ResponseEntity<Map<String, Object>> demo() {
		Map<String, Object> response = new HashMap<>();
		return ResponseEntity.ok(response);
	}

}
