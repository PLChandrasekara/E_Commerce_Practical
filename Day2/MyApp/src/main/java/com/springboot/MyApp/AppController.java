package com.springboot.MyApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")

public class AppController {
	@GetMapping("/msg")
	
	public String myMessage() {
		return "Hello Springboot";
	}
	
	@GetMapping("/name")
	
		public String myName() {
			return "Hello my name is pramudi";
		}
	
	@GetMapping("/course")
	
	public String myCourse() {
		return "My course is IT";
	}
	
}
