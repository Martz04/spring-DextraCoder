package com.dextratech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dextratech.dto.Problem;
import com.dextratech.dto.ResponseDTO;
import com.dextratech.services.ProblemService;

@Controller
public class AdminController {

	@Autowired
	private ProblemService problemService;
	
	@RequestMapping(value="/admin/problemForm", method=RequestMethod.GET)
	public String getAdmin(){
		return "problemForm";
	}
	
	@RequestMapping(value="/admin/problemUsers", method=RequestMethod.GET)
	public String getMapProblems(){
		return "problemUsers";
	}
	
	@RequestMapping(value="/admin/problemForm/save", 
			method=RequestMethod.POST, 
			produces="application/json",
			consumes="application/json")
	public @ResponseBody ResponseDTO saveProblem(@RequestBody Problem problem) {
		problemService.save(problem);
		ResponseDTO response = new ResponseDTO();
		response.setText("Success Adding Data");
		return response;
	}
}
