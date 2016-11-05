package com.lm.acaligiuri.salestax.salestaxes.basket;

import com.lm.acaligiuri.salestax.salestaxes.product.Product;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andreacaligiuri on 02/11/16.
 */
public class Basket {
    private List<Product> products = new LinkedList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }
}
