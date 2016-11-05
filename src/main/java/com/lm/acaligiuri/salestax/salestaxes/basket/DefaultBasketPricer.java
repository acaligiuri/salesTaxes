package com.lm.acaligiuri.salestax.salestaxes.basket;

import com.lm.acaligiuri.salestax.salestaxes.product.Product;

import java.math.BigDecimal;

/**
 * Created by andreacaligiuri on 05/11/16.
 */
public class DefaultBasketPricer implements BasketPricer {
    private static final BigDecimal POINT5 = new BigDecimal("0.05");
    public Receipt price(Basket basket) {
        Receipt receipt = new Receipt();
        for (Product product :basket.getProducts()) {
            price(receipt, product);
        }
        return receipt;
    }


    public void price(Receipt receipt, Product product) {
        BigDecimal productVat = product.getShelfPrice().multiply(product.getSalesTax());
        productVat = productVat.divide(POINT5, 0, BigDecimal.ROUND_UP).multiply(POINT5);
        BigDecimal takeHomePrice = productVat.add(product.getShelfPrice());

        StringBuilder builder = new StringBuilder();
        builder.append("1 ");
        if (product.isImported()) {
            builder.append("imported ");
        }
        receipt.setTotalTax(receipt.getTotalTax().add(productVat));
        receipt.setTotalPrice(receipt.getTotalPrice().add(takeHomePrice));
        builder.append(product.getName());
        receipt.newLine(builder.toString(), takeHomePrice, productVat);
    }
}
