package com.lm.acaligiuri.salestax.salestaxes.product;

import java.math.BigDecimal;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (getShelfPrice() != null ? !getShelfPrice().equals(product.getShelfPrice()) : product.getShelfPrice() != null)
            return false;
        if (this.isImported() != product.isImported()) {
            return false;
        }
        return getName() != null ? getName().equals(product.getName()) : product.getName() == null;

    }

    @Override
    public int hashCode() {
        int result = getShelfPrice() != null ? getShelfPrice().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (Objects.hashCode(isImported()));
        return result;
    }
}
