package sample04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	@Autowired
	private SungJukDTO2 sungJukDTO2 = null;
	@Autowired
	@Qualifier("arrayList")
	private List<SungJukDTO2> list = null;
	//private ArrayList<SungJukDTO2> list = null;
	
	@Override
	public void execute() {
		System.out.println();
		Scanner scanner = new Scanner(System.in);
		
		//데이터
		System.out.print("이름 입력 : ");
		String name = scanner.next();
		System.out.print("국어 입력 : ");
		int kor = scanner.nextInt();
		System.out.print("영어 입력 : ");
		int eng = scanner.nextInt();
		System.out.print("수학 입력 : ");
		int math = scanner.nextInt();
		System.out.println();
		
		int tot = kor + eng + math;
		double avg = tot /3.;
		
		sungJukDTO2.setName(name);
		sungJukDTO2.setKor(kor);
		sungJukDTO2.setEng(eng);
		sungJukDTO2.setMath(math);
		sungJukDTO2.setTot(tot);
		sungJukDTO2.setAvg(avg);
		
		//ArrayList에 담기
		//List<E> list = new ArrayList();
		list.add(sungJukDTO2);
		
		//출력
		System.out.println(name + "님의 데이터를 저장하였습니다");
	}

}










