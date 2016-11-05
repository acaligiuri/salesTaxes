package com.lm.acaligiuri.salestax.salestaxes.basket;

import com.lm.acaligiuri.salestax.salestaxes.product.Product;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by andreacaligiuri on 02/11/16.
 */
public class Basket {
    private Map<Product, Integer> products = new LinkedHashMap<>();

    public void addProduct(Product product) {
        Integer existingQuantity = products.get(product);
        if (existingQuantity == null) {
            existingQuantity = 0;
        }
        existingQuantity++;
        products.put(product, existingQuantity);
    }

    public Map<Product, Integer> getProducts() {
        return Collections.unmodifiableMap(products);
    }
}
