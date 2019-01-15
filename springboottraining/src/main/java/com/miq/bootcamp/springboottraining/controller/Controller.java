package com.miq.bootcamp.springboottraining.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String sampleEndpoint() {
		return "<h2 align = \"center\" > Hello world  </h1>";
	}
	
}
