package com.lm.acaligiuri.salestax.basket;

import com.lm.acaligiuri.salestax.salestaxes.basket.Basket;
import com.lm.acaligiuri.salestax.salestaxes.basket.BasketPricer;
import com.lm.acaligiuri.salestax.salestaxes.basket.DefaultBasketPricer;
import com.lm.acaligiuri.salestax.salestaxes.basket.Receipt;
import com.lm.acaligiuri.salestax.salestaxes.product.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by andreacaligiuri on 05/11/16.
 */
public class DefaultBasketPricerTest {
    private BasketPricer unit;

    @Before
    public void setup() {
        this.unit = new DefaultBasketPricer();
    }
    /**
     * Input 1:
     * 1 book at 12.49
     * 1 music CD at 14.99
     * 1 chocolate bar at 0.85
     *
     * Output 1:
     * 1 book : 12.49
     * 1 music CD: 16.49
     * 1 chocolate bar: 0.85
     * Sales Taxes: 1.50
     * Total: 29.83
     */
    @Test
    public void test1() {
        Basket basket = new Basket();
        basket.addProduct(Product.builder().title("book").price(new BigDecimal("12.49")).build());
        basket.addProduct(Product.builder().title("music CD").price(new BigDecimal("14.49")).build());
        basket.addProduct(Product.builder().title("chocolate bar").price(new BigDecimal("0.85")).build());

        Receipt receipt = unit.price(basket);
        assertNotNull(receipt);
        List<Receipt.ReceiptLine> receiptLineList = receipt.getReceiptLines();
        assertNotNull(receiptLineList);
        assertEquals(3, receiptLineList.size());

        assertEquals("1 book", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("12.49").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertEquals("1 music CD", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("16.49").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertEquals("1 chocolate bar", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("0.85").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertTrue(new BigDecimal("1.50").compareTo(receipt.getTotalTax()) == 0);
        assertTrue(new BigDecimal("29.83").compareTo(receipt.getTotalPrice()) == 0);
    }

    /**
     * Input 2:
     * 1 imported box of chocolates at 10.00
     * 1 imported bottle of perfume at 47.50
     *
     * Output 2:
     * 1 imported box of chocolates: 10.50
     * 1 imported bottle of perfume: 54.65
     * Sales Taxes: 7.65
     * Total: 65.15
     */
    @Test
    public void test2() {

        Basket basket = new Basket();
        basket.addProduct(Product.builder().title("box of chocolates").price(new BigDecimal("10.00")).imported().build());
        basket.addProduct(Product.builder().title("bottle of perfume").price(new BigDecimal("47.50")).imported().build());

        Receipt receipt = unit.price(basket);
        assertNotNull(receipt);
        List<Receipt.ReceiptLine> receiptLineList = receipt.getReceiptLines();
        assertNotNull(receiptLineList);
        assertEquals(2, receiptLineList.size());

        assertEquals("1 imported box of chocolates", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("10.50").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertEquals("1 imported bottle of perfume", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("54.65").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertTrue(new BigDecimal("7.65").compareTo(receipt.getTotalTax()) == 0);
        assertTrue(new BigDecimal("65.15").compareTo(receipt.getTotalPrice()) == 0);
    }

    /**
     * Input 3:
     * 1 imported bottle of perfume at 27.99
     * 1 bottle of perfume at 18.99
     * 1 packet of headache pills at 9.75
     * 1 box of imported chocolates at 11.25
     *
     * Output 3:
     * 1 imported bottle of perfume: 32.19
     * 1 bottle of perfume: 20.89
     * 1 packet of headache pills: 9.75
     * 1 imported box of chocolates: 11.85
     * Sales Taxes: 6.70
     * Total: 74.68
     */
    @Test
    public void test3() {

        Basket basket = new Basket();
        basket.addProduct(Product.builder().title("bottle of perfume").price(new BigDecimal("27.99")).imported().build());
        basket.addProduct(Product.builder().title("bottle of perfume").price(new BigDecimal("18.99")).build());
        basket.addProduct(Product.builder().title("packet of headache pills").price(new BigDecimal("9.75")).build());
        basket.addProduct(Product.builder().title("box of chocolates").price(new BigDecimal("11.25")).imported().build());

        Receipt receipt = unit.price(basket);
        assertNotNull(receipt);
        List<Receipt.ReceiptLine> receiptLineList = receipt.getReceiptLines();
        assertNotNull(receiptLineList);
        assertEquals(4, receiptLineList.size());

        assertEquals("1 imported bottle of perfume", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("12.49").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertEquals("1 bottle of perfume", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("16.49").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertEquals("1 packet of headache pills", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("0.85").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertEquals("1 imported box of chocolates", receiptLineList.get(0).title);
        assertTrue(new BigDecimal("0.85").compareTo(receipt.getReceiptLines().get(0).price)== 0);

        assertTrue(new BigDecimal("6.70").compareTo(receipt.getTotalTax()) == 0);
        assertTrue(new BigDecimal("74.68").compareTo(receipt.getTotalPrice()) == 0);
    }
}
