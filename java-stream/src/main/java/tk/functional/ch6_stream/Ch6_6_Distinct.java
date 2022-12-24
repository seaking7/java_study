package tk.functional.ch6_stream;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tk.functional.ch6_stream.model.Order;

public class Ch6_6_Distinct {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(3, -5, 4, -5, 2, 3);
		List<Integer> distinctNumbers = numbers.stream()
				.distinct()
				.collect(Collectors.toList());
		System.out.println(distinctNumbers);
		
		LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
		Order order1 = new Order()
				.setId(1001)
				.setStatus(Order.OrderStatus.CREATED)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(4));
		Order order2 = new Order()
				.setId(1002)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(103)
				.setCreatedAt(now.minusHours(1));
		Order order3 = new Order()
				.setId(1003)
				.setStatus(Order.OrderStatus.PROCESSED)
				.setCreatedByUserId(102)
				.setCreatedAt(now.minusHours(36));
		Order order4 = new Order()
				.setId(1004)
				.setStatus(Order.OrderStatus.ERROR)
				.setCreatedByUserId(104)
				.setCreatedAt(now.minusHours(40));
		Order order5 = new Order()
				.setId(1005)
				.setStatus(Order.OrderStatus.IN_PROGRESS)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(10));
		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		
		// TODO: created a sorted list of unique CreatedByUserIds from the orders
		List<Long> uniqSortedCreatedByUserId = orders.stream()
				.map(Order::getCreatedByUserId)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		System.out.println(uniqSortedCreatedByUserId);


	}

}
