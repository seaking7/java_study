package tk.functional.ch10_designPattern.email;

import tk.functional.ch10_designPattern.model.User;

public class VerifyYourEmailAddressEmailProvider implements EmailProvider {

	@Override
	public String getEmail(User user) {
		return "'Verify Your Email Address' email for " + user.getName();
	}

}
