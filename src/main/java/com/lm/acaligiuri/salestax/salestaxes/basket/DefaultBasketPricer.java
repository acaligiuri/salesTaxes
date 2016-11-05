package com.lm.acaligiuri.salestax.salestaxes.basket;

import com.lm.acaligiuri.salestax.salestaxes.product.Product;

import java.math.BigDecimal;

/**
 * Created by andreacaligiuri on 05/11/16.
 */
public class DefaultBasketPricer implements BasketPricer {
    public Receipt price(Basket basket) {
        Receipt receipt = new Receipt();
        BigDecimal totalPrice = BigDecimal.ZERO;
        BigDecimal totalVat = BigDecimal.ZERO;
        for (Product product :basket.getProducts()) {
            //TODO
        }
        receipt.setTotalPrice(totalPrice);
        receipt.setTotalTax(totalVat);
        return receipt;
    }


    public Receipt.ReceiptLine price(Product product) {
        //TODO
        return null;
    }
}
