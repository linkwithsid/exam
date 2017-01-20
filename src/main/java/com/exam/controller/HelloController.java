package com.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.exam.service.HelloService;


@Controller
@RequestMapping("/hello")
public class HelloController
{
	
	@Autowired
	HelloService helloService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String printHello(ModelMap  model) {
		model.addAttribute("message", helloService.getHelloResponse());
		return "hello";
	}

}