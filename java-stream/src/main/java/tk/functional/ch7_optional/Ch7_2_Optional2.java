package tk.functional.ch7_optional;

import java.util.Optional;

import tk.functional.ch7_optional.model.User;

public class Ch7_2_Optional2 {
	public static void main(String[] args) {
		Optional<User> maybeUser = Optional.ofNullable(maybeGetUser(true));
		maybeUser.ifPresent(System.out::println);
		
		Optional<Integer> maybeId = Optional.ofNullable(maybeGetUser(true))
			.map(user -> user.getId());
		maybeId.ifPresent(System.out::println);
		
		String userName = Optional.ofNullable(maybeGetUser(true))
			.map(User::getName)
			.map(name -> "The name is " + name)
			.orElse("Name is empty");
		System.out.println(userName);
		
		Optional<String> maybeEmail = Optional.ofNullable(maybeGetUser(true))
			.flatMap(User::getEmailAddress);
		maybeEmail.ifPresent(System.out::println);
	}
	
	public static User maybeGetUser(boolean returnUser) {
		if (returnUser) {
			return new User()
					  .setId(1001)
					  .setName("Alice")
					  .setEmailAddress("alice@fastcampus.co.kr")
					  .setVerified(false);
		}
		return null;
	}
}
