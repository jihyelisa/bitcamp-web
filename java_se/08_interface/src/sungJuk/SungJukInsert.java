package sungJuk;

import java.util.ArrayList;
import java.util.Scanner;

public class SungJukInsert implements SungJuk {
	
	@Override
	public void execute(ArrayList<SungJukDTO> arrayList) {
		Scanner scan = new Scanner(System.in);
		System.out.println();
		System.out.print("Insert your number: ");
		int no = scan.nextInt();
		System.out.print("Insert your name: ");
		String name = scan.next();
		System.out.print("Insert your grade of Korean: ");
		int kor = scan.nextInt();
		System.out.print("Insert your grade of English: ");
		int eng = scan.nextInt();
		System.out.print("Insert your grade of math: ");
		int math = scan.nextInt();
		
		SungJukDTO sungJukDTO = new SungJukDTO(no, name, kor, eng, math);
		sungJukDTO.calc();
		
		arrayList.add(sungJukDTO);
		
		System.out.println("Your data saved.");
	}

}
