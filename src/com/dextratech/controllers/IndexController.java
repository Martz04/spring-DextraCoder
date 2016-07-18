package com.dextratech.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dextratech.dao.UserDao;
import com.dextratech.dto.Rol;
import com.dextratech.dto.User;

@Controller
public class IndexController {

	@Autowired
	private UserDao userDao;
	
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
	
	@RequestMapping("/register")
	public String register(Model model) {
		
		model.addAttribute("newUser", new User());
		return "register";
	}
	
	@RequestMapping("/register/save")
	public String register(@ModelAttribute("newUser") User user, RedirectAttributes model) {
		User newUser = userDao.getUserByName(user.getName());
		if(newUser == null) {
			Set<Rol> roles = new HashSet<>();
			Rol rol = new Rol();
			rol.setDescription("Coder");
			roles.add(rol);
			user.setRoles(roles);
			userDao.saveNewUser(user);
			model.addFlashAttribute("status", "User register successfully");
		}else {
			model.addFlashAttribute("status", "Please select a different User name");
		}
		return "redirect:/register";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/";
	}
}
