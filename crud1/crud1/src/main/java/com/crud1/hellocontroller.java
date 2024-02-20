package com.crud1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class hellocontroller {
	@ResponseBody
	@RequestMapping("/hello")
	public String hello() {
		return "hi..there";
	}
}
