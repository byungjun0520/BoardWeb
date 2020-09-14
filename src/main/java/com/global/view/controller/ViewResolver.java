package com.global.view.controller;

/*  Controller 클래스가 리턴한 view 이름에 접두사 와 접미사를 결합하여 최종으로 실행
 *  될 view 경로와 파일명을 완성함
 *  
 *   DispatcherServlet 의 init()메소드를 호출될때 생성됨
 *   
 */


public class ViewResolver {
	
	
	public String prefix;// 접두사
	public String suffix;// 접미사 

   public void setPrefix(String prefix) {
	   this.prefix = prefix;
   }
	
   public void setSuffix(String suffix) {
	   this.suffix= suffix;
   }
   
   public String getView(String viewName) {
	   return prefix + viewName +suffix;
   }

	
}
