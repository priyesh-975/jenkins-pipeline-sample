package com.example.project;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PipeLineController {
	
	@GetMapping("/hello")
	public String sayHello()
	{
		return "hello Priyesh";
	}
	@GetMapping("/goodMorning")
	public String sayGoodMorning()
	{
		return "Good Morning Priyesh";
	}
	
	
	
}
