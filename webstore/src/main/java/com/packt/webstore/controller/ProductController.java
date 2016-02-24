package com.packt.webstore.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;

@RequestMapping("/products")
@Controller
public class ProductController {
	@Autowired
	private ProductService productService; 
	
	@RequestMapping
	public String list(Model model) {

		model.addAttribute("products", productService.getAllProducts());
	    return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
	  model.addAttribute("products", productService.getAllProducts());
	  
	return "products";
	}
	
	@RequestMapping("/{myCategoryId}")
	public String listProductsByCategory(Model model,@PathVariable("myCategoryId") String categoryId) {
		  model.addAttribute("products", productService.getProductsByCategory(categoryId));
			return "products";
	}
	
	@RequestMapping("/modelview")
	public ModelAndView allProducts() {
		ModelAndView modelView = new ModelAndView();
		modelView.addObject("products", productService.getAllProducts());
		modelView.setViewName("products");
		return modelView;
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(Model model,@MatrixVariable(pathVar="ByCriteria") Map<String, List<String>> filterParams) {
		Set<String> keys = filterParams.keySet();
		if(filterParams.containsKey("brand") || filterParams.containsKey("category"))
			model.addAttribute("products",productService.getProductsByFilter(filterParams));
		else
			model.addAttribute("products",productService.getProductsByPriceFilter(filterParams));
		return "products";
		
	}
	
	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
	  model.addAttribute("product", productService.getProductById(productId));
	  return "product";
	}
}
