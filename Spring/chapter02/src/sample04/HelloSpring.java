package sample04;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class HelloSpring {
	
	public void menu(ApplicationContext context) {
		Scanner scan = new Scanner(System.in);
		SungJuk sungJuk = null;
		int num;

		while(true) {
			System.out.println("**************");
			System.out.println("1. 입력");
			System.out.println("2. 출력");
			System.out.println("3. 수정");
			System.out.println("4. 삭제");
			System.out.println("5. 끝");
			System.out.println("**************");
			System.out.print("번호 입력: ");
			num = scan.nextInt();
			
			if(num == 5) break;
			
			else if(num == 1) sungJuk = context.getBean("sungJukInput", SungJuk.class);
			else if(num == 2) sungJuk = context.getBean("sungJukOutput", SungJuk.class);
			else if(num == 3) sungJuk = context.getBean("sungJukUpdate", SungJuk.class);
			else if(num == 4) sungJuk = context.getBean("sungJukDelete", SungJuk.class);
			
			sungJuk.execute();
		} //while
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
		helloSpring.menu(context);
		
		System.out.println("프로그램 종료");
	}
}
