package com.hack.chatgpt.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReturnCode {
	OAUTH_ERROR("1000", "You need to login"),

	NOT_FOUND_DATA("4000", "No data founded"),
	FAILED_BINDING_RESULT("9000", "Value is Null, or mismatched Type"),
	FAILED_INVALID_PARAMETER("9001", "Invalid parameter, Check the Value"),
	UNKNOWN_ERROR("9999", "Unable to process your request. Please try again later.");

	private String code;
	private String message;
}
