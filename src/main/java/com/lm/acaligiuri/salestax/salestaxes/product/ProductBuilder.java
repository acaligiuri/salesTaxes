package com.lm.acaligiuri.salestax.salestaxes.product;

import java.math.BigDecimal;

/**
 * Created by andreacaligiuri on 02/11/16.
 */
public class ProductBuilder {
    private Product product;

    private void ensureProduct() {
        if (product == null) {
            product = new Product();
        }
    }

    public ProductBuilder imported() {
        ensureProduct();
        this.product = new ImportTaxedProduct(product);
        return this;
    }

    public ProductBuilder salesTax() {
        ensureProduct();
        this.product = new SalesTaxedProduct(product);
        return this;
    }

    public ProductBuilder title(String title) {
        ensureProduct();
        product.setName(title);
        return this;
    }

    public ProductBuilder price(BigDecimal price) {
        ensureProduct();
        product.setShelfPrice(price);
        return this;
    }

    public Product build() {
        if (product == null || product.getName() == null || product.getShelfPrice() == null) {
            throw new IncompleteProductException("price and title should never be null in a product");
        }
        return product;
    }

    public static class IncompleteProductException extends RuntimeException {
        public IncompleteProductException(String s) {
            super(s);
        }
    }
}
