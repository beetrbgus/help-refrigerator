package com.refrigerator.helprefrigeratorbe.global.common;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class CommonApiResponse<T> {
	private boolean success;
	private T data;
	private ErrorResponse error;

	private CommonApiResponse(boolean success, T data, ErrorResponse error) {
		this.success = success;
		this.data = data;
		this.error = error;
	}

	public static <T> CommonApiResponse<T> success(T data) {
		return new CommonApiResponse<>(true, data, null);
	}

	public static CommonApiResponse<?> error(String code, String message) {
		return new CommonApiResponse<>(false, null, new ErrorResponse(code, message));
	}

	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ErrorResponse {
		private String code;
		private String message;

		public ErrorResponse(String code, String message) {
			this.code = code;
			this.message = message;
		}
	}
}
