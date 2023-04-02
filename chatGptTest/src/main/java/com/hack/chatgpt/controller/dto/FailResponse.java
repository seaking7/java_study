package com.hack.chatgpt.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hack.chatgpt.common.ReturnCode;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@JsonInclude(Include.NON_NULL)
@NoArgsConstructor
@AllArgsConstructor
public class FailResponse<T> {
	@Schema(description = "Return Code", example = "1000")
	private String returnCode;
	@Schema(description = "message", example = "You need to login")
	private String message;

	public static <T> FailResponse<T> fail(ReturnCode codeEnum) {
		return FailResponse.<T>builder()
			.returnCode(codeEnum.getCode())
			.message(codeEnum.getMessage())
			.build();
	}

	public static <T> FailResponse<T> fail(ReturnCode codeEnum, String errorMessage) {
		return FailResponse.<T>builder()
			.returnCode(codeEnum.getCode())
			.message(codeEnum.getMessage() + " [" + errorMessage + "]")
			.build();
	}



}
