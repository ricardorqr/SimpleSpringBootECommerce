package com.simpleSpringBootECommerce.controller;

import com.simpleSpringBootECommerce.model.CartItem;
import com.simpleSpringBootECommerce.model.Pricetype;
import com.simpleSpringBootECommerce.service.Cart;
import com.simpleSpringBootECommerce.service.ProductService;
import com.simpleSpringBootECommerce.validation.ProductValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CartController {

    @Autowired
    private ProductService productService;

    @Autowired
    private Cart cart;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new ProductValidation());
    }

    @RequestMapping(value = "/cart/add", method = RequestMethod.POST)
    public ModelAndView add(Long productId, Pricetype priceType, HttpSession session) {
        CartItem cartProduct = createItem(productId, priceType);
        cart.add(cartProduct);
        session.setAttribute("cart", cart);
        return new ModelAndView("redirect:/cart");
    }

    private CartItem createItem(Long produtoId, Pricetype priceType) {
//        Product product = productService.getProduct(produtoId);
//        return new CartItem(product, priceType);
        return new CartItem(null, priceType);
    }

    @RequestMapping("/cart")
    public ModelAndView itens(HttpSession session) {
        return new ModelAndView("cart/items");
    }

    @RequestMapping(value = "/cart/remove", method = RequestMethod.POST)
    public ModelAndView remover(Long productId, Pricetype priceType) {
        cart.remover(productId, priceType);
        return new ModelAndView("redirect:/cart");
    }

}
