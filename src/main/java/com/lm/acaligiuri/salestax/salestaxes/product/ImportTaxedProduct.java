package com.lm.acaligiuri.salestax.salestaxes.product;

import java.math.BigDecimal;

/**
 * Created by andreacaligiuri on 02/11/16.
 */
public class ImportTaxedProduct extends Product{
    protected Product decoratedProduct;

    private static final BigDecimal IMPORT_TAX_RATE = new BigDecimal("0.05");

    public ImportTaxedProduct(Product toDecorate) {
        if (toDecorate instanceof ImportTaxedProduct) {
            throw new IllegalArgumentException("Decorating a tax free product with another tax free product would have no result");
        }
        this.decoratedProduct = toDecorate;
    }

    @Override
    public BigDecimal getSalesTax() {
        return this.decoratedProduct.getSalesTax().add(IMPORT_TAX_RATE);
    }

    @Override
    public BigDecimal getShelfPrice() {
        return decoratedProduct.getShelfPrice();
    }

    @Override
    public void setShelfPrice(BigDecimal shelfPrice) {
        decoratedProduct.setShelfPrice(shelfPrice);
    }

    @Override
    public String getName() {
        return decoratedProduct.getName();
    }

    @Override
    public void setName(String name) {
        decoratedProduct.setName(name);
    }

    @Override
    public boolean isImported() {
        return true;
    }

    @Override
    public boolean isTaxFree() {
        return decoratedProduct.isTaxFree();
    }
}
