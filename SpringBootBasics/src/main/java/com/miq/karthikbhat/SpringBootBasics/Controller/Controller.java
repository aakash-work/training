package com.miq.karthikbhat.SpringBootBasics.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String sampleEndPoint(){
        return "Hello World";
    }
}
