package tk.functional.ch10_designPattern;

import java.util.Arrays;

import tk.functional.ch10_designPattern.model.User;
import tk.functional.ch10_designPattern.service.InternalUserService;
import tk.functional.ch10_designPattern.service.UserService;
import tk.functional.ch10_designPattern.service.UserServiceInFunctionalWay;

public class Ch10_4_TemplateMethod {
	public static void main(String[] args) {
		User alice = User.builder(1, "Alice")
				.with(builder -> {
					//builder.emailAddress = "alice@fastcampus.co.kr";
					builder.isVerified = false;
					builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
				}).build();
		
		UserService userService = new UserService();
		InternalUserService internalUserService = new InternalUserService();
		
		userService.createUser(alice);
		internalUserService.createUser(alice);
		
		UserServiceInFunctionalWay userServiceInFunctionalWay = new UserServiceInFunctionalWay(
				user -> {
					System.out.println("Validating user Func " + user.getName());
					return user.getName() != null && user.getEmailAddress().isPresent();
				},
				user -> {
					System.out.println("Writing user Func " + user.getName() + " to DB");
				});
		userServiceInFunctionalWay.createUser(alice);
	}
}
