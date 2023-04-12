package sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sample01.HelloSpring;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		
		MessageBean messageBean = context.getBean("messageBeanImpl", MessageBean.class);
		messageBean.sayHello();
		messageBean.sayHello("포도", 12000);
		messageBean.sayHello("딸기", 15000, 2);
	}
}
