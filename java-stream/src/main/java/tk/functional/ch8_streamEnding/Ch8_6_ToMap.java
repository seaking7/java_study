package tk.functional.ch8_streamEnding;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import tk.functional.ch8_streamEnding.model.Order;
import tk.functional.ch8_streamEnding.model.Order.OrderStatus;
import tk.functional.ch8_streamEnding.model.User;

public class Ch8_6_ToMap {

	public static void main(String[] args) {
		Map<Integer, String> numberMap = Stream.of(3, 5, -4, 2, 6)
				.collect(Collectors.toMap(Function.identity(), x -> "Number is " + x));
		System.out.println(numberMap.get(3));
		
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
	    Map<Integer, User> userIdToUserMap = users.stream()
	    		.collect(Collectors.toMap(User::getId, Function.identity()));
	    System.out.println(userIdToUserMap);
	    System.out.println(userIdToUserMap.get(103));
	    
	    Order order1 = new Order()
	    		.setId(1001L)
	    		.setAmount(BigDecimal.valueOf(2000))
	    		.setStatus(OrderStatus.CREATED);
        Order order2 = new Order()
        		.setId(1002L)
        		.setAmount(BigDecimal.valueOf(4000))
        		.setStatus(OrderStatus.ERROR);
        Order order3 = new Order()
        		.setId(1003L)
        		.setAmount(BigDecimal.valueOf(3000))
        		.setStatus(OrderStatus.ERROR);
        Order order4 = new Order()
        		.setId(1004L)
        		.setAmount(BigDecimal.valueOf(7000))
        		.setStatus(OrderStatus.PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);
        
        // TODO: Create a map from order id to order status
		Map<Long, OrderStatus> collect = orders.stream()
				.collect(Collectors.toMap(Order::getId, Order::getStatus));
		System.out.println("---"+ collect);

	}

}
