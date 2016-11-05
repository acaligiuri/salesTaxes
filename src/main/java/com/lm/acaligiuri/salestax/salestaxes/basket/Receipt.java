package com.lm.acaligiuri.salestax.salestaxes.basket;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by andreacaligiuri on 02/11/16.
 */
public class Receipt {
    private BigDecimal totalTax = BigDecimal.ZERO;
    private BigDecimal totalPrice = BigDecimal.ZERO;
    private List<ReceiptLine> receiptLines = new LinkedList<>();

    @Override
    public String toString() {
        //TODO
        return null;
    }

    public void newLine(String title, BigDecimal price) {
        receiptLines.add(new ReceiptLine(title, price));
    }

    public void setTotalTax(BigDecimal totalTax) {
        this.totalTax = totalTax;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getTotalTax() {
        return totalTax;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public List<ReceiptLine> getReceiptLines() {
        return receiptLines;
    }

    public class ReceiptLine {
        public String title;
        public BigDecimal price;

        public ReceiptLine(String title, BigDecimal price) {
            this.title = title;
            this.price = price;
        }
    }
}
