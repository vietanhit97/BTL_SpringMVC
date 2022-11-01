package com.controller.product;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.web.multipart.MultipartFile;
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
	@Autowired
	ServletContext servletContext;

	@GetMapping(value = "/data")
	public String home(@RequestParam(required = false) Map<String, String> param, Model model) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Product> data = productReponsitory.getListPaginate(page);
		model.addAttribute("data", data);
		Long count = productReponsitory.count();
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
			@RequestParam MultipartFile upload, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("p", p);
			List<Category> c = categoryReponsitory.getList();
			model.addAttribute("c", c);
			return "admin/product/insertProduct";
		} else {
			if (upload != null || !upload.isEmpty()) {

				String fileName = servletContext.getRealPath("/") + "resources\\images\\"
						+ upload.getOriginalFilename();
				p.setImage(upload.getOriginalFilename());
				try {
					upload.transferTo(new File(fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
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

	@GetMapping(value = "/preUpdate")
	public String preUpdate(@RequestParam("id") Integer id, Model model) {
		Product p = productReponsitory.getById(id);
		model.addAttribute("p", p);
		List<Category> c = categoryReponsitory.getList();
		model.addAttribute("c", c);
		return "admin/product/updateProduct";
	}

	@PostMapping(value = "/update")
	public String update(@Valid @ModelAttribute("p") Product p, BindingResult bindingResult, HttpSession session,
			@RequestParam MultipartFile upload, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("p", p);
			List<Category> c = categoryReponsitory.getList();
			model.addAttribute("c", c);
			return "admin/product/updateProduct";
		} else {
			if (upload != null || !upload.isEmpty()) {
				String fileName = servletContext.getRealPath("/") + "resources\\images\\"
						+ upload.getOriginalFilename();
				p.setImage(upload.getOriginalFilename());
				try {
					upload.transferTo(new File(fileName));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			boolean bl = productReponsitory.edit(p);
			if (bl) {
				return "redirect:/product/data";
			} else {
				model.addAttribute("p", p);
				List<Category> c = categoryReponsitory.getList();
				model.addAttribute("c", c);
				return "admin/product/updateProduct";
			}
		}
	}
	@PostMapping(value = "/searchProducts")
	public String search(@RequestParam("key") String key,@RequestParam(required = false) Map<String, String> param, Model model) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Product> data = productReponsitory.getByName(key,page);
		model.addAttribute("data", data);
		Long count = productReponsitory.countSearch(key);
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return "admin/product/searchListProducts";	
	}
}
