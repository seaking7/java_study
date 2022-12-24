package tk.functional.ch10_designPattern.email;

import tk.functional.ch10_designPattern.model.User;

public interface EmailProvider {
	String getEmail(User user);
}
