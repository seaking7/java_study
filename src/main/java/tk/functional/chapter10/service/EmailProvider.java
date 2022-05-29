package tk.functional.chapter10.service;

import tk.functional.chapter10.model.User;

public interface EmailProvider {
	String getEmail(User user);
}
