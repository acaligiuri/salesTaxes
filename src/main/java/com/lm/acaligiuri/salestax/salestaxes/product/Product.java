package com.lm.acaligiuri.salestax.salestaxes.product;

import java.math.BigDecimal;

/**
 * Created by andreacaligiuri on 02/11/16.
 */
public class Product {
    protected BigDecimal shelfPrice;
    protected String name;

    public BigDecimal getSalesTax() {
        return BigDecimal.ZERO;
    }

    public BigDecimal getShelfPrice() {
        return shelfPrice;
    }

    public void setShelfPrice(BigDecimal shelfPrice) {
        this.shelfPrice = shelfPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImported() {
        return false;
    }

    public boolean isTaxFree() {
        return false;
    }

    public static ProductBuilder builder() {
        return new ProductBuilder();
    }
}
