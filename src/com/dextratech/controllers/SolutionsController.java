package com.dextratech.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dextratech.dto.ProblemWithSolutionDTO;
import com.dextratech.services.SolutionService;

@Controller
public class SolutionsController {

	@Autowired
	private SolutionService service;
	
	@RequestMapping(value="/solutions")
	public String solutionsPage() {
		return "solutions";
	}
	
	@RequestMapping(value="/solutions/data", 
			method=RequestMethod.GET, 
			produces="application/json")
	public @ResponseBody List<ProblemWithSolutionDTO> getProblemsForUser(Principal principal) {
		return service.listAllProblemsForUserName(principal.getName());
	}
}
