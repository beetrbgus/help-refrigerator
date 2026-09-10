package com.refrigerator.helprefrigeratorbe.global.util;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public final class DateTimeUtils {

	private static final ZoneId KST_ZONE_ID = ZoneId.of("Asia/Seoul");
	private static final DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	private DateTimeUtils() {
		throw new UnsupportedOperationException("Utility class cannot be instantiated");
	}

	/**
	 * 현재 KST 기준 시간을 반환
	 * (System.currentTimeMillis()나 OS 기본 설정을 의존하지 않음)
	 */
	public static LocalDateTime now() {
		return LocalDateTime.now(KST_ZONE_ID);
	}

	public static String format(LocalDateTime dateTime) {
		if (dateTime == null) {
			return null;
		}
		return dateTime.format(DEFAULT_FORMATTER);
	}
}
