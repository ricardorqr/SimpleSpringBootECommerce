package com.simpleSpringBootECommerce.controller;

import com.simpleSpringBootECommerce.controller.dto.CartDTO;
import com.simpleSpringBootECommerce.model.CartItem;
import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import com.simpleSpringBootECommerce.repository.ProductRepository;
import com.simpleSpringBootECommerce.repository.TypeRepository;
import com.simpleSpringBootECommerce.service.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

@Controller
@Scope(value = WebApplicationContext.SCOPE_REQUEST)
public class CartController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private TypeRepository typeRepository;
    @Autowired
    private Cart cart;

    @RequestMapping(value = "/cart/add", method = RequestMethod.POST)
    public ModelAndView add(CartDTO cartDTO, HttpSession session) {
        CartItem item = createItem(cartDTO.getProductId(), cartDTO.getTypeId(), cartDTO.getPrice());
        cart.add(item);
        session.setAttribute("cart", cart);
        return new ModelAndView("redirect:/cart");
    }

    private CartItem createItem(Long productId, Long typeId, BigDecimal value) {
        Product product = productRepository.findById(productId).orElse(null);
        Type type = typeRepository.findById(typeId).orElse(null);
        return new CartItem(product, type, value);
    }

    @RequestMapping("/cart")
    public ModelAndView items(HttpSession session) {
        return new ModelAndView("cart/items");
    }

    @RequestMapping(value = "/cart/remove", method = RequestMethod.POST)
    public ModelAndView remover(Long productId, Long typeId, BigDecimal value) {
        CartItem item = createItem(productId, typeId, value);
        cart.remover(item);
        return new ModelAndView("redirect:/cart");
    }

}
