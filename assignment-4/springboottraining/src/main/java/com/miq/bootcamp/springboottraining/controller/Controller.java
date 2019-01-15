package com.miq.bootcamp.springboottraining.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class Controller {
	
	@RequestMapping(value="/test", method=RequestMethod.GET)
	public String sampleEndpoint() {
		return "Hello, World!";
	}
}
