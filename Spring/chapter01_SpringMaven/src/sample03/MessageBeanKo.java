package sample03;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//클래스명과 component id명이 다르면 괄호 안에 명시해야 함 (같으면 생략 가능)
@Component("messageBean")
@Scope("prototype")
public class MessageBeanKo implements MessageBean {
	private int num;	
	
	public MessageBeanKo() {
		System.out.println("MessageBeanKo 기본생성자");
	}

	@Override
	public void sayHello(String name) {
		num++;
		System.out.println("num = " + num);
		
		System.out.println("안녕! " + name);
	}

}
