package com.global.biz.comon;

import org.aspectj.lang.JoinPoint;

public class AfterThrowingAdvice {

	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		//System.out.println("[예외 처리] 비즈니스 로직 수행 중 예외 발생.....");
		// JoinPoint 를 매개변수로 받고 발생한 예외 객체를 바인딩 변수를 통해서 받음
		String method = jp.getSignature().getName();
		/*
		 * System.out.println("[예외 처리] "+method+
		 * "() 메소드 수행 중 발생된 예외 메시지 :"+exceptObj.getMessage());
		 */
		System.out.println(method+"() 메소드 수행 중 예외발생 !!!!");
		
		if(exceptObj instanceof IllegalArgumentException) {
			System.out.println("부적합한 값이 입력 되었습니다.");
		}else if(exceptObj instanceof NumberFormatException) {
			System.out.println("숫자형식의 값이 아닙니다.");
		}else if(exceptObj instanceof Exception){
			System.out.println(" 문제가 발생했습니다. ");
		}

		
		
	}
	
}
