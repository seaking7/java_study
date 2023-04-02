package com.hack.chatgpt.common.exception;

import com.hack.chatgpt.common.ReturnCode;

public class OauthException extends BaseException {

	public OauthException() {
		super(ReturnCode.OAUTH_ERROR);
	}

	public OauthException(ReturnCode returnCode) {
		super(returnCode);
	}

	public OauthException(String errorMsg) {
		super(errorMsg, ReturnCode.OAUTH_ERROR);
	}

	public OauthException(String message, ReturnCode returnCode) {
		super(message, returnCode);
	}
}
