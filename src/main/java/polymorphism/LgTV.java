package polymorphism;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("tv")
public class LgTV  implements TV{

	//@Autowired
	//@Qualifier("apple")
	@Resource(name="apple")
	private Speaker speaker;
	
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("LgTV --- 전원 켠다. ");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("LgTV --- 전원 끈다. ");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		//System.out.println("LgTV --- 소리 올린다. ");
		speaker.volumeUp();
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		//System.out.println("LgTV --- 소리 내린다. ");
		speaker.volumeDown();
	}

	/*
	 * public void turnOn() { System.out.println("LgTV --- 전원 켠다. "); }
	 * 
	 * public void turnOff() { System.out.println("LgTV --- 전원 끈다. "); }
	 * 
	 * public void soundUp() { System.out.println("LgTV --- 소리 올린다. "); }
	 * 
	 * public void soundDown() { System.out.println("LgTV --- 소리 내린다. "); }
	 */
}
