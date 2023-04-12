package sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
	@NonNull
	private String fruit;
	@Setter
	private int cost, qty;

//	//생성자로 데이터 받기 (Constructor Injection)
//	public MessageBeanImpl(String fruit) {
//		this.fruit = fruit;
//	}
//	//setter로 데이터 받기
//	public void setCost(int cost) {
//		this.cost = cost;
//	}
//	public void setQty(int qty) {
//		this.qty = qty;
//	}

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
