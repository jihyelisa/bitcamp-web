package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukService {
	private ArrayList<SungJukDTO> arrayList = new ArrayList<SungJukDTO>();
	//컬렉션ArrayList는 Object 타입이기 때문에 무엇이든 담을 수 있다.
	//무엇을 담을지 규정(제한)할 수 있다. - generic
	
	public void menu() {
		int num;
		SungJuk sungJuk = null;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		
		//menu list
		System.out.println("\n**********************");
		System.out.println("	1. Insert");
		System.out.println("	2. List");
		System.out.println("	3. Update");
		System.out.println("	4. Delete");
		System.out.println("	5. Sort");
		System.out.println("	6. Program off");
		System.out.println("**********************");
		System.out.print(" Number Select: ");
		
		//number select
		num = scan.nextInt();
		if (num==6) break;
		else if (num==1) sungJuk = new SungJukInsert();
		else if (num==2) sungJuk = new SungJukList();
		else if (num==3) sungJuk = new SungJukUpdate();
		else if (num==4) sungJuk = new SungJukDelete();
		else if (num==5) sungJuk = new SungJukSort();
		else {
			System.out.println("Wrong number, insert again.");
			System.out.println();
			continue;
		}
		
		sungJuk.execute(arrayList);
		}
	}
}
