package com.hack.chatgpt.common.exception;

import com.hack.chatgpt.common.ReturnCode;

public class NotFoundException extends BaseException {

	public NotFoundException() {
		super(ReturnCode.NOT_FOUND_DATA);
	}

	public NotFoundException(ReturnCode returnCode) {
		super(returnCode);
	}

	public NotFoundException(String errorMsg) {
		super(errorMsg, ReturnCode.NOT_FOUND_DATA);
	}

	public NotFoundException(String message, ReturnCode returnCode) {
		super(message, returnCode);
	}
}
