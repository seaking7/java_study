package tk.functional.ch6_stream;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tk.functional.ch6_stream.model.Order;
import tk.functional.ch6_stream.model.User;

public class Ch6_4_Stream2 {

	public static void main(String[] args) {
		User user1 = new User()
				.setId(101)
				.setName("Alice")
				.setVerified(true)
				.setEmailAddress("alice@fastcampus.co.kr");
		User user2 = new User()
				.setId(102)
				.setName("Bob")
				.setVerified(false)
				.setEmailAddress("bob@fastcampus.co.kr");
		User user3 = new User()
				.setId(103)
				.setName("Charlie")
				.setVerified(false)
				.setEmailAddress("charlie@fastcampus.co.kr");
		List<User> users = Arrays.asList(user1, user2, user3);
		
		List<String> emails = new ArrayList<>();
		for (User user: users) {
			if (!user.isVerified()) {
				String email = user.getEmailAddress();
				emails.add(email);
			}
		}
		System.out.println(emails);
		
		List<String> emails2 = users.stream()
				.filter(user -> !user.isVerified())
				.map(User::getEmailAddress)
				.collect(Collectors.toList());
		System.out.println(emails2);
		
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
				.setCreatedAt(now.minusHours(15));
		Order order5 = new Order()
				.setId(1005)
				.setStatus(Order.OrderStatus.IN_PROGRESS)
				.setCreatedByUserId(101)
				.setCreatedAt(now.minusHours(10));
		List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
		
		// TODO: Find orders in Error status, and extract createdByUserIds as a list
		List<Long> collect = orders.stream()
				.filter(order -> order.getStatus() == Order.OrderStatus.ERROR)
				.map(order -> order.getCreatedByUserId())
				.collect(Collectors.toList());

		// TODO: Find orders in ERROR status and created within 24 hours
		List<Long> ordersInErrorsIn24hrs = orders.stream()
				.filter(order -> (order.getStatus() == Order.OrderStatus.ERROR))
				.filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
				.map(Order::getCreatedByUserId)
				.collect(Collectors.toList());
		System.out.println(collect);
		System.out.println(ordersInErrorsIn24hrs);



	}

}
