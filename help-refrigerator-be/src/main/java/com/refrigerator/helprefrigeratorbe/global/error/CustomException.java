package com.refrigerator.helprefrigeratorbe.global.error;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {
	private final CommonErrorCode errorCode;

	public CustomException(CommonErrorCode errorCode) {
		super(errorCode.getMessage());
		this.errorCode = errorCode;
	}

	public CustomException(CommonErrorCode errorCode, String customMessage) {
		super(customMessage);
		this.errorCode = errorCode;
	}
}
