package tk.functional.ch10_designPattern;

import tk.functional.ch10_designPattern.model.User;

public class Ch10_1_BuilderPattern {

	public static void main(String[] args) {
		User user = User.builder(1, "Alice")
				.with(builder -> {
					builder.emailAddress = "alice@fastcampus.co.kr";
					builder.isVerified = true;
				}).build();
		System.out.println(user);
	}

}
