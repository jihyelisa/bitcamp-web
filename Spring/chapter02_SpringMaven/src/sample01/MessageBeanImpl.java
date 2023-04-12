package sample01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public class MessageBeanImpl implements MessageBean {
	private String fruit;
	private int cost, qty;

	//생성자로 데이터 받기 (Constructor Injection)
	public MessageBeanImpl(@Value("사과") String fruit) {
		this.fruit = fruit;
	}
	
	//setter로 데이터 받기
	//@Autowired - 생성자가 아닌 메소드에 걸면 실행시 생성자처럼 자동으로 실행
	@Autowired
	public void setCost(@Value("5000") int cost) {
		this.cost = cost;
	}
	@Autowired
	public void setQty(@Value("3") int qty) {
		this.qty = qty;
	}

	@Override
	public void sayHello() {
		System.out.println(fruit + "\t" + cost + "원\t" + qty + "개");
	}

	@Override
	public void sayHello(String fruit, int cost) {
		System.out.println(fruit + "\t" + cost + "원\t" + qty + "개");
	}

	@Override
	public void sayHello(String fruit, int cost, int qty) {
		System.out.println(fruit + "\t" + cost + "원\t" + qty + "개");
	}
}
