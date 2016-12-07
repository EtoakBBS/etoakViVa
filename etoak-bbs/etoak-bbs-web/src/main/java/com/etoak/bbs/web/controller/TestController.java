package com.etoak.bbs.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views")
public class TestController {

	@RequestMapping("/aaa")
	public String toPage() {

		System.out.println(5555);

		return "test.html";
	}

	@RequestMapping("/bbb")
	public void index(HttpServletRequest request, HttpServletResponse response){
		int a = 5 / 0;
		System.out.println(a);

	}
}
