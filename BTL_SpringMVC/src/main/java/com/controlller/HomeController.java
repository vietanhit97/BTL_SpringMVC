package com.controlller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class HomeController {
	@RequestMapping(value = "home")
	public String home() {
		return "admin/home";
	}
	@RequestMapping(value = "test")
	public String hometest() {
		return "admin/test";
	}
}
