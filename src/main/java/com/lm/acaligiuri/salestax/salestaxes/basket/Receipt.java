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

    public void newLine(String title, BigDecimal price, BigDecimal vat) {
        receiptLines.add(new ReceiptLine(title, price, vat));
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

    public static class ReceiptLine {
        private String title;
        private BigDecimal totalPrice;
        private BigDecimal vat;

        private ReceiptLine(String title, BigDecimal totalPrice, BigDecimal vat) {
            this.title = title;
            this.totalPrice = totalPrice;
            this.vat = vat;
        }

        public String getTitle() {
            return title;
        }


        public BigDecimal getTotalPrice() {
            return totalPrice;
        }

        public BigDecimal getVat() {
            return vat;
        }
    }
}
