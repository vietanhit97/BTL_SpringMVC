package com.controller.category;

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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.model.Category;
import com.reponsitory.DaoReponsitory;

@Controller
@RequestMapping(value = "/category")
public class CategoryController {
	@Autowired
	private DaoReponsitory<Category, Integer> daoReponsitory;

	@GetMapping(value = "/data")
	public String home(@RequestParam(required = false) Map<String, String> param, Model model) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Category> data = daoReponsitory.getListPaginate(page);
		model.addAttribute("data", data);
		Long count = daoReponsitory.count();
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return "admin/category/category";
	}

	@GetMapping(value = "/delete")
	public String remove(@RequestParam("id") Integer id) {
		Boolean bl = daoReponsitory.remove(id);
		return "redirect:/category/data";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		Category category = new Category();
		model.addAttribute("c", category);
		return "admin/category/insertCategory";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("c") Category c, BindingResult bindingResult, HttpSession session,
			Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("c", c);
			return "admin/category/insertCategory";
		} else {
			boolean bl = daoReponsitory.add(c);
			if (bl) {
				return "redirect:/category/data";
			} else {
				model.addAttribute("c", c);
				return "admin/category/insertCategory";
			}
		}
	}

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		Category c = daoReponsitory.getById(id);
		model.addAttribute("c", c);
		return "admin/category/updateCategory";
	}

	@PostMapping(value = "/update")
	public String update(@ModelAttribute("category") Category c, HttpSession session, Model model) {

		boolean bl = daoReponsitory.edit(c);
		if (bl) {
			return "redirect:/category/data";
		} else {
			model.addAttribute("c", c);
			return "admin/category/updateCategory";
		}
	}

	@GetMapping(value = "/searchCategores")
	public String search(@RequestParam("key") String key,@RequestParam(required = false) Map<String, String> param, 
			Model model) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Category> data = daoReponsitory.getByName(key, page);
		model.addAttribute("data", data);
		Long count = daoReponsitory.countSearch(key);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		model.addAttribute("key", key);
		return "admin/category/searchListCategories";
	}
}
