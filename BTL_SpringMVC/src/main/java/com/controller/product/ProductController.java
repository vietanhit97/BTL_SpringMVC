package com.controller.product;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.Category;
import com.model.Product;
import com.reponsitory.DaoReponsitory;

@Controller
@RequestMapping(value = "/product")
public class ProductController {
	@Autowired
	private DaoReponsitory<Category, Integer> categoryReponsitory;
	@Autowired
	private DaoReponsitory<Product, Integer> productReponsitory;

	@GetMapping(value = "/data")
	public String home(@RequestParam(required = false) Map<String, String> param, Model model) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Product> data = productReponsitory.getListPaginate(page);
		model.addAttribute("data", data);
		Long count = productReponsitory.Count();
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return "admin/product/product";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		Product p = new Product();
		model.addAttribute("p", p);
		List<Category> c = categoryReponsitory.getList();
		model.addAttribute("c", c);
		return "admin/product/insertProduct";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("p") Product p, BindingResult bindingResult, HttpSession session,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("p", p);
			List<Category> c = categoryReponsitory.getList();
			model.addAttribute("c", c);
			return "admin/product/insertProduct";
		} else {
			boolean bl = productReponsitory.add(p);
			if (bl) {
				return "redirect:/product/data";
			} else {
				model.addAttribute("p", p);
				List<Category> c = categoryReponsitory.getList();
				model.addAttribute("c", c);
				return "admin/product/insertCategory";
			}
		}
	}
}
