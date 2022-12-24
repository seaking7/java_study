package tk.simul.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.simul.controller.dto.UserDto;

@RestController
public class TestController {

	@GetMapping("/api/test")
	public UserDto viewUserDto(){

		UserDto user = new UserDto();
		user.setName("test");
		user.setValue("value1");
		return user;
	}

}
