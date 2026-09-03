package com.refrigerator.helprefrigeratorbe.global.error;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CommonErrorCode {
	// Common (공통)
	INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "C001", "잘못된 입력값입니다."),
	METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "C002", "지원하지 않는 HTTP 메서드입니다."),
	INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "C003", "서버 내부 오류가 발생했습니다."),

	// Recipe (레시피 도메인)
	RECIPE_NOT_FOUND(HttpStatus.NOT_FOUND, "R001", "존재하지 않는 레시피입니다."),

	// Ingredient (식재료 도메인)
	INGREDIENT_NOT_FOUND(HttpStatus.NOT_FOUND, "I001", "등록되지 않은 식재료입니다.");

	private final HttpStatus status;
	private final String code;
	private final String message;
}
