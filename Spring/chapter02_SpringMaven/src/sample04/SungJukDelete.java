package sample04;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SungJukDelete implements SungJuk {
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list = null;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
	
		System.out.print("삭제할 이름 입력: ");
		String name = scan.next();
		
		//Iterator - 리스트의 데이터를 삭제해도 인덱스가 앞으로 당겨지지 않음
		//.next()로 데이터를 하나씩 꺼낼 때마다 버퍼에 잠시 저장함
		Iterator<SungJukDTO2> it = list.iterator();
		int search = 0;

		while(it.hasNext()) {
			SungJukDTO2 sungJukDTO2 = it.next();
			if(sungJukDTO2.getName().equals(name)) {
				search = 1;
				
				System.out.println("\n이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2.getName() + "\t" +
								   sungJukDTO2.getKor() + "\t" +
								   sungJukDTO2.getEng() + "\t" +
								   sungJukDTO2.getMath() + "\t" +
								   sungJukDTO2.getTot() + "\t" +
								   sungJukDTO2.getAvg() + "\n");
				it.remove();
				break;
			} //if
		} //while
		
		if(search==0) System.out.println("찾는 이름이 없습니다.");
		else System.out.println("삭제되었습니다.");
		System.out.println();
	}
}
