package io.github.paulmarcelinbejan.toolbox.utils.log.audit;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.CodeSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class AuditHandler {

	@Around("execution(@io.github.paulmarcelinbejan.toolbox.utils.log.audit.Audit * *(..))")
    public Object logMethodInfo(ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
		String methodName = signature.getName();
        String className = signature.getDeclaringTypeName();
		
        // Log method name and parameters before execution
        logBeforeExecution(methodName, className, joinPoint);

        // Proceed with the method execution
        Object result = joinPoint.proceed();

        // Log method name and result after execution
        logAfterExecution(methodName, className, result);

        return result;
    }

	private static void logBeforeExecution(String methodName, String className, ProceedingJoinPoint joinPoint) {
		String parameters = extractParameters(joinPoint);
		log.debug("Method '{}' of Class '{}' is about to be executed with following parameters: {}", methodName, className, parameters);
    }
    
    private static void logAfterExecution(String methodName, String className, Object result) {
		log.debug("Method '{}' of Class '{}' executed successfully. Return value: '{}'", methodName, className, result);
    }
    
	private static String extractParameters(ProceedingJoinPoint joinPoint) {
		String parameters;
		CodeSignature codeSignature = (CodeSignature) joinPoint.getSignature();
    	String[] names = codeSignature.getParameterNames();
    	if(names != null && names.length > 0) {
    		Object[] values = joinPoint.getArgs();
    		
    		StringBuilder parametersBuilder = new StringBuilder();
    		for (int i = 0; i < names.length; i++) {
    			parametersBuilder.append("'")
    					  .append(names[i])
    					  .append(" : ")
    					  .append(String.valueOf(values[i]))
    					  .append("'")
    					  .append(", ");
    		}
    		parametersBuilder.delete(parametersBuilder.length() - 2, parametersBuilder.length()); // Remove the trailing comma and space
    		
    		parameters = parametersBuilder.toString();
    	} else {
    		parameters = "NO PARAMETERS";
    	}
		return parameters;
	}
	
}
