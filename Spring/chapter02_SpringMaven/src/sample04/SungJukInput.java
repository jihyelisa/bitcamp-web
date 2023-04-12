package sample04;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class SungJukInput implements SungJuk {
	//SungJukDTO2, ArrayList bean을 찾아 자동으로 매핑해라
	@Autowired
	private SungJukDTO2 sungJukDTO2 = null;
	@Autowired
	@Qualifier("arrayList") //부모클래스 안의 많은 자식클래스 중 어떤 빈을 가져올 것인지 명시
	private List<SungJukDTO2> list = null;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);

		//데이터
		System.out.print("이   름 입력 : ");
		String name = scan.next();
		System.out.print("국어점수 입력 : ");
		int kor = scan.nextInt();
		System.out.print("영어점수 입력 : ");
		int eng = scan.nextInt();
		System.out.print("수학점수 입력 : ");
		int math = scan.nextInt();
		
		int tot = kor + eng + math;
		double avg = tot / 3.;
		
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
		System.out.println(name + "님의 데이터를 입력 하였습니다\n");
	}
}
