package io.github.paulmarcelinbejan.toolbox.utils.log.duration;

import java.lang.reflect.Method;
import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import io.github.paulmarcelinbejan.toolbox.utils.time.duration.DurationUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class TimeExecutionHandler {

	@Around("execution(@io.github.paulmarcelinbejan.toolbox.utils.log.duration.TimeExecution * *(..))")
	public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.nanoTime();
		Object result = joinPoint.proceed();
		long endTime = System.nanoTime();
		long executionTimeNanos = endTime - startTime;

		String className = joinPoint.getTarget().getClass().getSimpleName();
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		
		printExecutionTime(className, method.getName(), executionTimeNanos);

		return result;
	}

	private static void printExecutionTime(String className, String methodName, long executionTimeNanos) {
		log.info("Method '{}' of Class '{}' executed in {}",
				methodName,
				className,
				durationToTimeUnits(executionTimeNanos));
	}
	
	private static String durationToTimeUnits(long nanos) {
		EnumMap<TimeUnit, Long> timeUnitValueMap = DurationUtils.splitNanosIntoTimeUnitsWithAscOrder(nanos);
		StringBuilder stringBuilder = new StringBuilder();
		
        for (Entry<TimeUnit, Long> timeUnitValueEntry : timeUnitValueMap.entrySet()) {
        	TimeUnit timeUnit = timeUnitValueEntry.getKey();
        	Long timeUnitValue = timeUnitValueEntry.getValue();
        	
        	if(timeUnitValue == 0) {
        		continue;
        	}
        	
        	stringBuilder.insert(0, timeUnitValue + " " + timeUnit.name() + ", ");
        }

        // Remove the trailing comma and space
        stringBuilder.setLength(stringBuilder.length() - 2);

        return stringBuilder.toString();
	}
	
}
