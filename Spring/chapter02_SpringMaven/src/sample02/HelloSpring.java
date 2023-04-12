package sample02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {
	
	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("applicationContext.xml");
		
		Calc calc = context.getBean("calcAdd", Calc.class);
		calc.calculate();
		calc = context.getBean("calcMul", Calc.class);
		calc.calculate();
	}
}
