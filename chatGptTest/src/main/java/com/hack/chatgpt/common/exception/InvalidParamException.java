package com.hack.chatgpt.common.exception;

import com.hack.chatgpt.common.ReturnCode;

public class InvalidParamException extends BaseException {

	public InvalidParamException() {
		super(ReturnCode.FAILED_INVALID_PARAMETER);
	}

	public InvalidParamException(ReturnCode returnCode) {
		super(returnCode);
	}

	public InvalidParamException(String errorMsg) {
		super(errorMsg, ReturnCode.FAILED_INVALID_PARAMETER);
	}

	public InvalidParamException(String message, ReturnCode returnCode) {
		super(message, returnCode);
	}
}
