package com.dextratech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dextratech.dto.Problem;
import com.dextratech.services.ProblemService;

@Controller
public class AdminController {

	@Autowired
	private ProblemService problemService;
	
	@RequestMapping(value="/admin/problemForm", method=RequestMethod.GET)
	public String getAdmin(){
		return "problemForm";
	}
	
	@RequestMapping(value="/admin/problemForm/save", method=RequestMethod.POST, consumes="application/json")
	public String saveProblem(@RequestBody Problem problem) {
		System.out.println(problem);
		//problemService.save(problem);
		
		return "redirect:/admin";
	}
}
