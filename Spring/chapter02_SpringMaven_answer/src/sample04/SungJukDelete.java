package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class SungJukDelete implements SungJuk {
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list = null;

	@Override
	public void execute() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("삭제 할 이름 입력 : ");
		String name = scanner.next();
		
		Iterator<SungJukDTO2> it = list.iterator();
		int sw=0;
		while(it.hasNext()) {
			SungJukDTO2 sungJukDTO2 = it.next(); //it가 가리키는 곳의 항목을 꺼내서 저장한 후 it는 다음 항목으로 이동
			
			if(sungJukDTO2.getName().equals(name)) {
				sw=1;
				it.remove(); //아까 따로 보관한 항목을 제거
				System.out.println(name+"님의 데이터를 삭제하였습니다");
			}//if			
		}//while
		
		if(sw == 0) System.out.println("찾고자하는 이름이 없습니다");

	}

}











