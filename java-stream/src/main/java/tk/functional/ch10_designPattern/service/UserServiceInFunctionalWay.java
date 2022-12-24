package tk.functional.ch10_designPattern.service;

import java.util.function.Consumer;
import java.util.function.Predicate;

import tk.functional.ch10_designPattern.model.User;

public class UserServiceInFunctionalWay {
	private final Predicate<User> validateUser;
	private final Consumer<User> writeToDB;
	
	public UserServiceInFunctionalWay(Predicate<User> validateUser, Consumer<User> writeToDB) {
		this.validateUser = validateUser;
		this.writeToDB = writeToDB;
	}
	
	public void createUser(User user) {
		if (validateUser.test(user)) {
			writeToDB.accept(user);
		} else {
			System.out.println("Cannot create user");
		}
	}
}
