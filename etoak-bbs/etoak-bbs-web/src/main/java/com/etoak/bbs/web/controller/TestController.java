package com.etoak.bbs.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller    
@RequestMapping("/views") 
public class TestController   {
	
	@RequestMapping("/aaa")
	public String toPage(){
		
		System.out.println(5555);
		
		return "test.html";
	}
}
