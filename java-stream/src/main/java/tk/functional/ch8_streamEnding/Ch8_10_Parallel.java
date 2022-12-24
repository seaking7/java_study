package tk.functional.ch8_streamEnding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import tk.functional.ch8_streamEnding.model.User;
import tk.functional.ch8_streamEnding.service.EmailService;

public class Ch8_10_Parallel {

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
	    User user4 = new User()
	            .setId(104)
	            .setName("David")
	            .setEmailAddress("david@fastcampus.co.kr")
	            .setVerified(true);
        User user5 = new User()
        		.setId(105)
        		.setName("Eve")
        		.setEmailAddress("eve@fastcampus.co.kr")
        		.setVerified(false);
        User user6 = new User()
        		.setId(106)
        		.setName("Frank")
        		.setEmailAddress("frank@fastcampus.co.kr")
        		.setVerified(false);
	    List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6);

		EmailService emailService = new EmailService();
	    long startTime = System.currentTimeMillis();
	    users.stream()
	    	.filter(user -> !user.isVerified())
	    	.forEach(emailService::sendVerifyYourEmailEmail);
	    long endTime = System.currentTimeMillis();
	    System.out.println("Sequential: " + (endTime - startTime) + "ms");
	    
	    startTime = System.currentTimeMillis();
	    users.stream().parallel()
	    	.filter(user -> !user.isVerified())
	    	.forEach(emailService::sendVerifyYourEmailEmail);
	    endTime = System.currentTimeMillis();
	    System.out.println("Parallel: " + (endTime - startTime) + "ms");
	    
	    List<User> processedUsers = users.parallelStream()
	    		.map(user -> {
	    			System.out.println("Capitalize user name for user " + user.getId());
	    			user.setName(user.getName().toUpperCase());
	    			return user;
	    		})
	    		.map(user -> {
	    			System.out.println("Set 'isVerified' to true for user " + user.getId());
	    			user.setVerified(true);
	    			return user;
	    		})
	    		.collect(Collectors.toList());
	    System.out.println(processedUsers);
	}

}
