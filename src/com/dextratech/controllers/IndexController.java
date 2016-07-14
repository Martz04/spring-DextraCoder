package com.dextratech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@RequestMapping(value="/DextraCoder/")
	public String getRoot() {
		return "index";
	}
	
	@RequestMapping(value="/")
	public String getIndex() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/";
	}
}
