package sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");
		
		SungJuk sungJuk = context.getBean("sungJukImpl", SungJuk.class);
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display();
		
		sungJuk.modify();
		sungJuk.calcTot();
		sungJuk.calcAvg();
		sungJuk.display();
	}

}
