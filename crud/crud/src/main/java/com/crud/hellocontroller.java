package com.crud;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hellocontroller {
	@ResponseBody
	@RequestMapping("/message")
	public String hello() {
		return "hi..there";
	}
}
