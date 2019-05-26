package practice3;

import java.math.BigDecimal;

public class PriceCaculator {

    public PriceCaculator(){}

    public BigDecimal calculate(Order order) {
        BigDecimal subTotal = new BigDecimal(0);

        // Total up line items
        for (OrderLineItem lineItem : order.getOrderLineItemList()) {
            subTotal = subTotal.add(lineItem.getPrice());
        }

        // Subtract discounts
        for (BigDecimal discount : order.getDiscounts()) {
            subTotal = subTotal.subtract(discount);
        }

        // calculate tax
        BigDecimal tax = subTotal.multiply(order.getTax());

        // calculate GrandTotal
        BigDecimal grandTotal = subTotal.add(tax);

        return grandTotal;
    }
}
