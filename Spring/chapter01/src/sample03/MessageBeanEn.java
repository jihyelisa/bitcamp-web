package sample03;

public class MessageBeanEn implements MessageBean {
	private int num;	
	
//	public MessageBeanEn() {
//		System.out.println("MessageBeanEn 기본생성자");
//	}

	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num = " + num);
		
		System.out.println("Hello! " + name);
	}
}
