package sample01;

import lombok.Setter;

public class MessageBeanImpl implements MessageBean {
	@Setter
	private String str;

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
