package practice3;

import java.math.BigDecimal;
import java.util.List;

public class Order extends PriceCaculator{

    public Order(List<OrderLineItem> orderLineItemList, List<BigDecimal> discounts) {
        super.orderLineItemList = orderLineItemList;
        super.discounts = discounts;
        super.tax = new BigDecimal(0.1);
    }

}
