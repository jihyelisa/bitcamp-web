package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
// 타겟 클래스
public class MessageBeanImpl implements MessageBean {
	private String str;

	@Autowired
	public void setStr(@Value("Have ") String str) {
		this.str = str;
	}

	@Override
	public void showPrintBefore() {
		System.out.println("showPrintBefore message = " + str); //핵심코드
	}

	@Override
	public void viewPrintBefore() {
		try {
			Thread.sleep(1000); //1초간 정지 후 움직이게 함
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore message = " + str); //핵심코드
	}

	@Override
	public void showPrintAfter() {
		System.out.println("showPrintAfter message = " + str); //핵심코드
	}

	@Override
	public void viewPrintAfter() {
		try {
			Thread.sleep(1000); //1초간 정지 후 움직이게 함
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintAfter message = " + str); //핵심코드
	}

	@Override
	public String showPrint() {
		System.out.println("showPrint message = " + str); //핵심코드
		return "스프링";
	}

	@Override
	public void viewPrint() {
		try {
			Thread.sleep(1000); //1초간 정지 후 움직이게 함
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("viewPrintBefore message = " + str); //핵심코드
	}
	
	@Override
	public void display() {
		System.out.println("display message = " + str); //핵심코드
	}
}
