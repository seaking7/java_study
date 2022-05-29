package tk.functional.ch9_etc.priceprocessor;

import java.math.BigDecimal;
import java.util.function.Function;

import tk.functional.ch9_etc.model.Order;
import tk.functional.ch9_etc.model.OrderLine;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {

	@Override
	public Order apply(Order order) {
		return order.setAmount(order.getOrderLines().stream()
				.map(OrderLine::getAmount)
				.reduce(BigDecimal.ZERO, BigDecimal::add));
	}

}
