package com.test.intern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@CrossOrigin
@SpringBootApplication(scanBasePackages={
		"com.test.intern.canal","com.test.intern.serialization","com.test.intern.besoin"})
public class InternApplication {

	public static void main(String[] args) {
		SpringApplication.run(InternApplication.class, args);
	}

	@GetMapping
	String print() {
		return "Backend for the ITNS task";
	}

}
