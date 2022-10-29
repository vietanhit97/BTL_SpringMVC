package com.controlller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Category;
import com.reponsitory.DaoReponsitory;

@Controller
@RequestMapping(value = "category")
public class HomeController {
	@Autowired
	private DaoReponsitory<Category, Integer> daoReponsitory;

	@GetMapping(value = "data")
	public String home(@RequestParam(required = false) Map<String, String> param, Model model) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Category> data = daoReponsitory.getListPaginate(page);
		model.addAttribute("data", data);
		Long count = daoReponsitory.Count();
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return "admin/home";
	}

	@GetMapping(value = "test")
	public String home( Model model) {
		return "admin/test";
	}
}
