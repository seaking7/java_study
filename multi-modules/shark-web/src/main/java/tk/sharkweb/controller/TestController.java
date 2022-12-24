package tk.sharkweb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.common.domain.Member;
import tk.sharkweb.controller.dto.UserDto;

@RestController
public class TestController {

	@GetMapping("/web/test")
	public UserDto viewUserDto(){

		UserDto user = new UserDto();
		user.setName("test");
		user.setValue("value1");
		return user;
	}

	@GetMapping("/web/member")
	public Member getMember(){
		Member member = new Member("taekyung", "seaking7@gmail.com", "");
		return member;
	}
}
