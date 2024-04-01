package io.github.paulmarcelinbejan.toolbox.utils.log.context;

import java.util.UUID;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.MDC;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class ContextHandler {

	@Around("execution(@io.github.paulmarcelinbejan.toolbox.utils.log.context.Context * *(..))")
	public Object addContextParameters(ProceedingJoinPoint joinPoint) throws Throwable {
		String uniqueIdentifier = UUID.randomUUID().toString();

		MDC.put(ContextFieldName.UNIQUE_IDENTIFIER.name(), uniqueIdentifier);

		return joinPoint.proceed();
	}

}
