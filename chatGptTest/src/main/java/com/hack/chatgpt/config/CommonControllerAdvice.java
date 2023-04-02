package com.hack.chatgpt.config;

import org.springframework.core.NestedExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.hack.chatgpt.common.ReturnCode;
import com.hack.chatgpt.common.exception.BaseException;
import com.hack.chatgpt.common.exception.InvalidParamException;
import com.hack.chatgpt.common.exception.NotFoundException;
import com.hack.chatgpt.common.exception.OauthException;
import com.hack.chatgpt.controller.dto.FailResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class CommonControllerAdvice {

	// 정의되지 않은 예외. 별도 모니터링 필요
	@ResponseBody
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = Exception.class)
	public FailResponse onException(Exception exception) {
		log.warn("onException= {}", exception.getMessage());
		return FailResponse.fail(ReturnCode.UNKNOWN_ERROR);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.OK)
	@ExceptionHandler(value = {BaseException.class})
	public FailResponse onBaseException(BaseException exception) {
		log.warn("BaseException = {}", exception.getMessage());
		return FailResponse.fail(ReturnCode.UNKNOWN_ERROR);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {InvalidParamException.class})
	public FailResponse onInvalidParamException(InvalidParamException exception) {
		log.warn("invalidParamException = {}", exception.getMessage());
		return FailResponse.fail(ReturnCode.FAILED_INVALID_PARAMETER);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {NotFoundException.class})
	public FailResponse onNotFoundException(NotFoundException exception) {
		log.warn("NotFoundException = {}", exception.getMessage());
		return FailResponse.fail(ReturnCode.NOT_FOUND_DATA);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {OauthException.class})
	public FailResponse onNotFoundException(OauthException exception) {
		log.warn("OauthException = {}", exception.getMessage());
		return FailResponse.fail(ReturnCode.OAUTH_ERROR);
	}

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = {BindException.class})
	public FailResponse onBindException(BindException exception) {
		log.warn("BIND Exception = {}", NestedExceptionUtils.getMostSpecificCause(exception).getMessage());
		return FailResponse.fail(ReturnCode.FAILED_BINDING_RESULT);
	}

}
