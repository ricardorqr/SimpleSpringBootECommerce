package com.simpleSpringBootECommerce.controller;

import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.repository.ProductRepository;
import com.simpleSpringBootECommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private ProductRepository productRepository;

	@RequestMapping("/")
//	@Cacheable(value = "products")
	public ModelAndView index() {
		List<Product> products = (List<Product>) productRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("products", products);
		return modelAndView;
	}
	
}
