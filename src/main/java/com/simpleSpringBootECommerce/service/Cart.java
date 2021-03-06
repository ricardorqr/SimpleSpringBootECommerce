package com.simpleSpringBootECommerce.service;

import com.simpleSpringBootECommerce.model.CartItem;
import com.simpleSpringBootECommerce.model.Pricetype;
import com.simpleSpringBootECommerce.model.Product;
import com.simpleSpringBootECommerce.model.Type;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.context.annotation.ScopedProxyMode.TARGET_CLASS;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = TARGET_CLASS)
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;
    private final Map<CartItem, Integer> items = new HashMap<>();

    public void add(CartItem item) {
        items.put(item, getQuantity(item) + 1);
    }

    public Integer getQuantity(CartItem item) {
        if (!items.containsKey(item)) {
            items.put(item, 0);
        }
        return items.get(item);
    }

    public int getQuantity() {
        return items.values().stream().reduce(0, (proximo, acumulador) -> (proximo + acumulador));
    }

    public BigDecimal getTotal(CartItem item) {
        return item.getTotal(getQuantity(item));
    }

    public BigDecimal getTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (CartItem item : items.keySet()) {
            total = total.add(getTotal(item));
        }
        return total;
    }

    public Collection<CartItem> getItems() {
        return items.keySet();
    }

    public void remover(CartItem item) {
        items.remove(item);
    }

}
