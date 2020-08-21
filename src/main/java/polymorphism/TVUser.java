package polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class TVUser {

	public static void main(String[] args) {
		/*
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();
	*/
		
	//	System.out.println("------------------");
		
//		TV tv = new LgTV();
	//	TV tv = new SamsungTV();
	
		/*
		BeanFactory factory = new BeanFactory();
		TV tv =(TV)factory.getBean(args[0]);
		
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

*/
		
		// 1. Spring 컨테이너를 구동함
		AbstractApplicationContext factory 
		= new GenericXmlApplicationContext("applicationContext.xml");
		
		// 2. Spring 컨테이너로부터 필요한 객체를 요청함
		
		  TV tv =(TV)factory.getBean("tv");
		  tv.powerOn();
		  tv.volumeUp();
		  tv.volumeDown();
		  tv.powerOff();
		 //스프링 컨테이너로부터 필요한 객체를 요청
		// TV  tv = (TV)factory.getBean("tv");
			/*
			 * TV tv1 = (TV)factory.getBean("tv"); TV tv2 = (TV)factory.getBean("tv"); TV
			 * tv3 = (TV)factory.getBean("tv");
			 */
		 
		// 3. Spring 컨테이너를 종료함
		factory.close();
	}

}
