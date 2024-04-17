package com.tiles;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Maincontroller 
{
	
	  @RequestMapping("/") 
	  public String view1() { 
		  return "index"; 
	  }
	 
	  @RequestMapping("/home")
	  public String view2() {
		  return "Home";
	  }
	
	  @RequestMapping("/contact") 
	  public String view3() { 
		  return "Contact"; 
	  }
	 
}
