package io.github.paulmarcelinbejan.toolbox.exception.utils;

import java.util.UUID;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionUtils {

	public static String getUniqueIdentifier() {
		return UUID.randomUUID().toString();
	}
	
	public static String getStackTrace(Exception exception) {
		return org.apache.commons.lang3.exception.ExceptionUtils.getStackTrace(exception);
	}
	
}
