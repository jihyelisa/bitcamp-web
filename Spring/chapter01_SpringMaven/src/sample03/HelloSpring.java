package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		//applicationContext.xml 읽어오기
		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");

		MessageBean messagebean = (MessageBean) context.getBean("messageBean");
		messagebean.sayHello("Spring");
		
		MessageBean messagebean2 = context.getBean("messageBean",MessageBean.class);
											//getBean 메소드 안에서 형변환할 수 있음
		messagebean2.sayHello("Spring");
		
		MessageBean messagebean3 = (MessageBean) context.getBean("messageBean");
		messagebean3.sayHello("Spring");
	}
}
