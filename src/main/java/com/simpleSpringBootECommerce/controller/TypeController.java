package com.simpleSpringBootECommerce.controller;

import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import com.simpleSpringBootECommerce.repository.ProductRepository;
import com.simpleSpringBootECommerce.repository.TypeRepository;
import com.simpleSpringBootECommerce.service.ProductService;
import com.simpleSpringBootECommerce.validation.ProductValidation;
import com.simpleSpringBootECommerce.validation.TypeValidation;
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

@Controller
public class TypeController {

	@Autowired
	private TypeRepository typeRepository;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new TypeValidation());
	}

	@RequestMapping("/type/form")
	public ModelAndView form(Type type) {
		ModelAndView modelAndView = new ModelAndView("type/form");
		modelAndView.addObject("types", typeRepository.findAll());
		System.out.println(typeRepository.findAll());
		return modelAndView;
	}

	@RequestMapping("/type/list")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("type/list");
		modelAndView.addObject("types", typeRepository.findAll());
		return modelAndView;
	}

	@RequestMapping(value = "/type/addType", method = RequestMethod.POST)
//	@CacheEvict(value="products", allEntries=true)
	@Transactional
	public ModelAndView add(@Valid Type type, BindingResult bindingResult,
			RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return form(type);
		}

		typeRepository.save(type);
		redirectAttributes.addFlashAttribute("success", "New type inserted");
		ModelAndView modelAndView = new ModelAndView("redirect:list");
		return modelAndView;
	}
//
//	@RequestMapping("/product/detail/{id}")
//	public ModelAndView detalhe(@PathVariable("id") Long id){
//	    ModelAndView modelAndView = new ModelAndView("product/detail");
//	    Product product = productService.getProduct(id);
//	    modelAndView.addObject("product", product);
//	    return modelAndView;
//	}

}
