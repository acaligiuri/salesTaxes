package com.lm.acaligiuri.salestax.product;

import com.lm.acaligiuri.salestax.salestaxes.product.Product;
import com.lm.acaligiuri.salestax.salestaxes.product.ProductBuilder;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andreacaligiuri on 05/11/16.
 */
public class ProductBuilderTest {
    private ProductBuilder unit;

    @Before
    public void setup() {
        unit = new ProductBuilder();
    }

    @Test(expected = ProductBuilder.IncompleteProductException.class)
    public void nameLessProduct() {
        unit.price(BigDecimal.TEN).build();
    }

    @Test(expected = ProductBuilder.IncompleteProductException.class)
    public void priceLessProduct() {
        unit.title("Priceless product").build();
    }

    @Test(expected = ProductBuilder.IncompleteProductException.class)
    public void incompleteProduct() {
        unit.build();
    }

    @Test
    public void testTaxFreeProduct() {
        Product product = unit.title("Tax Free Product").price(BigDecimal.TEN).build();
        assertEquals("Tax Free Product", product.getName());
        assertEquals(BigDecimal.TEN, product.getShelfPrice());
        assertTrue(BigDecimal.ZERO.compareTo(product.getSalesTax())==0 );
    }
    @Test
    public void testTaxFreeImportedProduct() {
        Product product = unit.title("Tax Free Imported Product").price(BigDecimal.TEN).imported().build();
        assertEquals("Tax Free Imported Product", product.getName());
        assertEquals(BigDecimal.TEN, product.getShelfPrice());
        assertTrue(new BigDecimal("0.05").compareTo(product.getSalesTax()) == 0 );
    }
    @Test
    public void testSalesTaxProduct() {
        Product product = unit.title("Sales Taxed Product").price(BigDecimal.TEN).salesTax().build();
        assertEquals("Sales Taxed Product", product.getName());
        assertEquals(BigDecimal.TEN, product.getShelfPrice());
        assertTrue(new BigDecimal("0.10").compareTo(product.getSalesTax())== 0 );
    }
    @Test
    public void testImportedSalesTaxedProduct() {
        Product product = unit.title("Imported Sales Taxed Product").price(BigDecimal.TEN).imported().salesTax().build();
        assertEquals("Imported Sales Taxed Product", product.getName());
        assertEquals(BigDecimal.TEN, product.getShelfPrice());
        assertTrue(new BigDecimal("0.15").compareTo(product.getSalesTax()) ==0);
    }
    @Test
    public void testSalesTaxedImportedProduct() {
        Product product = unit.title("Sales Taxed Imported Product").price(BigDecimal.TEN).salesTax().imported().build();
        assertEquals("Sales Taxed Imported Product", product.getName());
        assertEquals(BigDecimal.TEN, product.getShelfPrice());
        assertTrue(new BigDecimal("0.15").compareTo(product.getSalesTax()) == 0);
    }
}
