package com.refrigerator.helprefrigeratorbe.global.error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.refrigerator.helprefrigeratorbe.global.common.CommonApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomException.class)
	protected ResponseEntity<CommonApiResponse<?>> handleBusinessException(CustomException e) {
		log.warn("BusinessException: {}", e.getMessage());
		CommonErrorCode errorCode = e.getErrorCode();
		return ResponseEntity
			.status(errorCode.getStatus())
			.body(CommonApiResponse.error(errorCode.getCode(), e.getMessage()));
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	protected ResponseEntity<CommonApiResponse<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		log.warn("MethodArgumentNotValidException: {}", e.getMessage());
		String errorMessage = e.getBindingResult().getAllErrors().get(0).getDefaultMessage();
		return ResponseEntity
			.status(CommonErrorCode.INVALID_INPUT_VALUE.getStatus())
			.body(CommonApiResponse.error(CommonErrorCode.INVALID_INPUT_VALUE.getCode(), errorMessage != null ? errorMessage : CommonErrorCode.INVALID_INPUT_VALUE.getMessage()));
	}

	/**
	 * 위에서 캐치하지 못한 예측 불가능한 서버 예외 (최후의 보루)
	 */
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<CommonApiResponse<?>> handleException(Exception e) {
		log.error("Unhandled Exception", e);
		return ResponseEntity
			.status(CommonErrorCode.INTERNAL_SERVER_ERROR.getStatus())
			.body(CommonApiResponse.error(CommonErrorCode.INTERNAL_SERVER_ERROR.getCode(), CommonErrorCode.INTERNAL_SERVER_ERROR.getMessage()));
	}
}
