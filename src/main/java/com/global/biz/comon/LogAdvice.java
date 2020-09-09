package com.global.biz.comon;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;


@Service // 빈 등록 대신 사용함
@Aspect // Aspect = Pointcut + Advice
public class LogAdvice {

	@Pointcut("execution(* com.global.biz..*Impl.*(..))")
	public void allPointcut() {// 참조 메소드
		// 몸체가 비어있는 즉, 구현 로직이 없는 메소드임
		// 단순하게 포인트컷을 식별하는 이름으로만 사용하는 메소드
	}
	@Pointcut("execution(* com.global.biz..*Impl.get*(..))")
	public void getPointcut() {// 참조메소드
		// 몸체가 비어있는 즉, 구현 로직이 없는 메소드임
		
	}
//	@Before("getPointcut()") // 비즈니스 메소드 실행 전에 동작함
	//@Before("allPointcut()") // 비즈니스 메소드 실행 전에 동작함
	public void printLog() {
		System.out.println("[공통로그] 비즈니스 로직 수행 전 동작");
	}
	
}
