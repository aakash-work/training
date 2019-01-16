package com.miq.bootcamp.springboottraining.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Definition of all the end points

@RestController
public class Controller {
	//what end point served and method attached
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public String sampleEndpoint()
	{
		return "Hello World!";
	}
}
