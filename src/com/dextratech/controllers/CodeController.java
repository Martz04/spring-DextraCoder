package com.dextratech.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dextratech.dto.CompiledResponseDTO;
import com.dextratech.dto.ProblemParametersDTO;
import com.dextratech.dto.User;
import com.dextratech.dto.UserSolutionDTO;
import com.dextratech.services.CodeService;
import com.dextratech.services.ProblemService;
import com.dextratech.services.UserService;

@Controller
public class CodeController {

	@Autowired
	private CodeService codeService;
	@Autowired
	private ProblemService problemService;
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/problem/random",
			produces="application/json",
			method=RequestMethod.GET)
	public @ResponseBody ProblemParametersDTO setProblemToResolve() {
		//TODO Mock User,
		User user = userService.getUserbyId(1);
		return problemService.getRandomProblemForUser(user);
	}
	
	@RequestMapping(value="/compile",
			consumes="application/json",
			produces="application/json", 
			method=RequestMethod.POST)
	public @ResponseBody CompiledResponseDTO compileResult(
			@RequestBody UserSolutionDTO solution, 
			HttpSession session,
			HttpServletRequest request, Principal principal) {
		Integer numberOfTries = setNumberOfTries(session);
		CompiledResponseDTO response = codeService.executeSolutionForProblem(solution, 
				request.getServletContext().getRealPath("/"), principal, numberOfTries);
		if(response.isFinish()) {
			session.setAttribute("numberOfTries", 0);
		}
		return response;
	}

	private Integer setNumberOfTries(HttpSession session) {
		Integer numberOfTries = (Integer)session.getAttribute("numberOfTries");
		if(numberOfTries == null) {
			numberOfTries = new Integer(1);
			session.setAttribute("numberOfTries", numberOfTries);
		}else {
			session.setAttribute("numberOfTries", numberOfTries + 1);
		}
		return numberOfTries;
	}
	
	@RequestMapping(value="/timeout",
			consumes="application/json",
			produces="application/json", 
			method=RequestMethod.POST)
	public @ResponseBody CompiledResponseDTO timeout(
			@RequestBody UserSolutionDTO solution, HttpServletRequest request, 
			Principal principal, HttpSession session) {
		Integer numberOfTries = setNumberOfTries(session);
		CompiledResponseDTO response = codeService.executeSolutionForProblem(solution, 
				request.getServletContext().getRealPath("/"), principal, numberOfTries);
		response.setFinish(true);
		return response;
	}
}
