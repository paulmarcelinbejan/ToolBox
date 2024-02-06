package io.github.paulmarcelinbejan.toolbox.utils.log.audit;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AuditHandler {

	@Around("execution(@io.github.paulmarcelinbejan.toolbox.utils.log.audit.Audit * *(..))")
    public Object logMethodInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        String methodName = joinPoint.getSignature().getName();
        String className = joinPoint.getTarget().getClass().getSimpleName();

        // Log method name and parameters before execution
        logBeforeExecution(methodName, className, joinPoint.getArgs());

        // Proceed with the method execution
        Object result = joinPoint.proceed();

        // Log method name and result after execution
        logAfterExecution(methodName, className, result);

        return result;
    }

    private static void logBeforeExecution(String methodName, String className, Object[] args) {
        String parameters = args != null && args.length > 0 ? argsToString(args) : "NO PARAMETERS";
		log.trace("Method '{}' of Class '{}' is about to be executed with following parameters: '{}'", methodName, className, parameters);
    }

    private static void logAfterExecution(String methodName, String className, Object result) {
		log.trace("Method '{}' of Class '{}' executed successfully. Result: '{}'", methodName, className, result);
    }
    
    private static String argsToString(Object[] args) {
    	return Arrays.stream(args)
    			.map(String::valueOf)
                .collect(Collectors.joining(", "));
    }
	
}
