package com.hack.chatgpt.common.exception;

import com.hack.chatgpt.common.ReturnCode;

import lombok.Getter;

@Getter
public class BaseException extends RuntimeException {
	private ReturnCode returnCode;

	public BaseException() {
	}

	public BaseException(ReturnCode returnCode) {
		super(returnCode.getMessage());
		this.returnCode = returnCode;
	}

	public BaseException(String message, ReturnCode returnCode) {
		super(message);
		this.returnCode = returnCode;
	}

	public BaseException(String message, ReturnCode returnCode, Throwable cause) {
		super(message, cause);
		this.returnCode = returnCode;
	}
}
