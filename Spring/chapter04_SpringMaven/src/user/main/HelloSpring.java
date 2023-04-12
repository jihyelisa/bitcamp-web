package user.main;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import user.service.UserService;

@Component
public class HelloSpring {

		public void menu(ApplicationContext context) {
			Scanner scan = new Scanner(System.in);
			UserService userService = null;
			int num;

			while(true) {
				System.out.println("\n**************");
				System.out.println("1. 입력");
				System.out.println("2. 출력");
				System.out.println("3. 수정");
				System.out.println("4. 삭제");
				System.out.println("5. 끝");
				System.out.println("**************");
				System.out.print("번호 입력: ");
				num = scan.nextInt();
				
				if(num == 5) break;
				
				else if(num == 1) userService = context.getBean("userInsertService", UserService.class);
				else if(num == 2) userService = context.getBean("userSelectService", UserService.class);
				else if(num == 3) userService = context.getBean("userUpdateService", UserService.class);
				else if(num == 4) userService = context.getBean("userDeleteService", UserService.class);
				else {
					System.out.println("1~5번만 입력하십시오.");
					continue;
				}
				userService.execute();
			} //while
		}

		public static void main(String[] args) {
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			HelloSpring helloSpring = (HelloSpring) context.getBean("helloSpring");
			helloSpring.menu(context);
			
			System.out.println("프로그램 종료");
		}
}
