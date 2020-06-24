package com.simpleSpringBootECommerce.controller;

import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.repository.ProductRepository;
import com.simpleSpringBootECommerce.repository.TypeRepository;
import com.simpleSpringBootECommerce.service.ProductService;
import com.simpleSpringBootECommerce.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private TypeRepository typeRepository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProductValidation());
	}

	@RequestMapping("/product/form")
	public ModelAndView form(Product product) {
		ModelAndView modelAndView = new ModelAndView("product/form");
		modelAndView.addObject("types", typeRepository.findAll());
		return modelAndView;
	}

	@RequestMapping("/product/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("product/list");
		modelAndView.addObject("products", productRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/product/addProduct", method = RequestMethod.POST)
//	@CacheEvict(value="products", allEntries=true)
	@Transactional
	public ModelAndView addProduct(@Valid Product product, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return form(product);
		}

		productService.save(product);
		redirectAttributes.addFlashAttribute("success", "New product inserted");
		ModelAndView modelAndView = new ModelAndView("redirect:list");
		return modelAndView;
	}
	
	@RequestMapping("/product/detail/{id}")
	public ModelAndView detail(@PathVariable("id") Long id){
	    ModelAndView modelAndView = new ModelAndView("product/detail");
	    Product product = productRepository.findById(id).orElse(null);
	    modelAndView.addObject("product", product);
	    return modelAndView;
	}

}
