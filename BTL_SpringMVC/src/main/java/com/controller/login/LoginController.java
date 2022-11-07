package com.controller.login;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Account;
import com.reponsitory.LoginReponsitory;

@Controller
public class LoginController {
	@Autowired
	private LoginReponsitory loginReponsitory;

	@GetMapping(value = "/login")
	public String login(Model model) {
		Account account = new Account();
		model.addAttribute("a", account);
		return "admin/login/login";
	}

	@PostMapping(value = "/login")
	public String login(@Valid @ModelAttribute("a") Account a, BindingResult bindingResult, HttpSession session,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("a", a);
			return "admin/login/login";
		} else {
			String userName = a.getName();
			String password = a.getPassword();
			Account account = loginReponsitory.getAccount(userName, password);
			if (account != null) {
				session.setAttribute("user", userName);
				return "redirect:/loginHomeAdmin";
			} else {
				return "redirect:/login";
			}
		}
	}

	@GetMapping(value = "/loginHomeAdmin")
	public String loginHomeAdmin(HttpSession session) {
		Object user = session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		} else {
			return "index";
		}
	}
	@GetMapping(value = "/logOutHomeAdmin")
	public String logOutHomeAdmin(HttpSession session) {
			session.removeAttribute("user");
			return "redirect:/login";
	}
}
