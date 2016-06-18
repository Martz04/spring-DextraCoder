package com.dextratech.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dextratech.dto.CompiledResponseDTO;
import com.dextratech.dto.UserSolutionDTO;
import com.dextratech.services.CodeService;

@Controller
public class CodeController {

	@Autowired
	private CodeService codeService;
		
	@RequestMapping(value="/compile",
			consumes="application/json",
			produces="application/json", 
			method=RequestMethod.POST)
	public @ResponseBody CompiledResponseDTO compileResult(
			@RequestBody UserSolutionDTO solution, HttpServletRequest request) {
		 
        return codeService.executeSolutionForProblem(solution, 
				request.getServletContext().getRealPath("/"));
	}
}
