package com.global.biz.comon;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;


@Service
@Aspect

public class AroundAdvice {

	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
		
		String method=pjp.getSignature().getName();
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		
		//System.out.println("[BEFORE] : 비즈니스 메소드 수행 전에 처리할 내용....");
		Object obj = pjp.proceed();		
		//System.out.println("[AFTER] : 비즈니스 메소드 수행 후에 처리할 내용....");
		stopWatch.stop();
		
		System.out.println(method+"() 메소드 수행에 걸린시간 :"+
		stopWatch.getTotalTimeMillis()+"(ms)초");
		
		return obj;
	}
}