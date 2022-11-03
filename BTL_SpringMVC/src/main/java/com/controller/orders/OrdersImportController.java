package com.controller.orders;

import java.util.Date;
import java.util.List;
import java.util.Map;
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
import com.model.Orders;
import com.model.Product;
import com.reponsitory.DaoReponsitory;

@Controller
@RequestMapping(value = "/ordersImport")
public class OrdersImportController {
	@Autowired
	private DaoReponsitory<Product, Integer> productReponsitory;
	@Autowired
	private DaoReponsitory<Orders, Integer> ordersReponsitory;

	@GetMapping(value = "/data")
	public String home(@RequestParam(required = false) Map<String, String> param, Model model) {
		int page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Orders> data = ordersReponsitory.getListPaginate(page);
		model.addAttribute("data", data);
		Long count = ordersReponsitory.count();
		model.addAttribute("count", count);
		model.addAttribute("page", page);
		return "admin/ordersImport/ordersImport";
	}

	@GetMapping(value = "/initInsert")
	public String add(Model model) {
		Orders o = new Orders();
		List<Product> p = productReponsitory.getList();
		model.addAttribute("o", o);
		model.addAttribute("p", p);
		return "admin/ordersImport/addOrdersImport";
	}

	@PostMapping(value = "/insert")
	public String insert(@Valid @ModelAttribute("o") Orders o, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			List<Product> p = productReponsitory.getList();
			model.addAttribute("o", o);
			model.addAttribute("p", p);
			return "admin/ordersImport/addOrdersImport";
		} else {
			Product p = productReponsitory.getById(o.getProductId().getId());
			p.setQuantity(p.getQuantity() + o.getQuantity());
			o.setTotalAmount(o.getQuantity() * p.getPrice());
			o.setDate(new Date());
			ordersReponsitory.add(o);
			productReponsitory.edit(p);
			return "redirect:/ordersImport/data";
		}
	}
	@GetMapping(value = "/delete")
	public String remove(@RequestParam("id") Integer id) {
		ordersReponsitory.delete(id);
		return "redirect:/ordersImport/data";
	}
	@GetMapping(value = "/detail")
	public String detail(@RequestParam("id") Integer id , Model model) {
		Orders o = ordersReponsitory.getById(id);
		model.addAttribute("o", o);
		return "/ordersImport/data";
	}
}
