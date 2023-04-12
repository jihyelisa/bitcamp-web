package sample04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import sample03.MessageBean;

public class HelloSpring {

	public static void main(String[] args) {
		ApplicationContext context = new FileSystemXmlApplicationContext("src/applicationContext.xml");

		Calc calc;
		calc = (Calc) context.getBean("calcAdd");
		calc.caculate(25, 36);
		calc = context.getBean("calcMul", Calc.class);
		calc.caculate(25, 36);

	}

}
