package sample02;

public class HelloSpring {

	public static void main(String[] args) {
		//MessageBeanKo messageBeanKo = new MessageBeanKo(); //1:1관계, 결합도100%
		
		//다형성, 부모=자식, 결합도 낮아짐
		MessageBean messageBean = new MessageBeanKo();
		
		messageBean.sayHello("스프링");
	}

}
