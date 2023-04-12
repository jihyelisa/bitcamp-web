package sample04;

import java.util.List;
import java.util.Scanner;

import lombok.Setter;

public class SungJukUpdate implements SungJuk {
	@Setter
	private List<SungJukDTO2> list = null;

	@Override
	public void execute() {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("수정할 이름 입력: ");
		String name = scan.next();
		
		int search = 0;
		for(SungJukDTO2 sungJukDTO2 : list) {
			if(sungJukDTO2.getName().equals(name)) {
				search = 1;
				
				System.out.println("\n이름\t국어\t영어\t수학\t총점\t평균");
				System.out.println(sungJukDTO2.getName() + "\t" +
				   		   		   sungJukDTO2.getKor() + "\t" +
				   		   		   sungJukDTO2.getEng() + "\t" +
				   		   		   sungJukDTO2.getMath() + "\t" +
				   		   		   sungJukDTO2.getTot() + "\t" +
				   		   		   sungJukDTO2.getAvg() + "\n");
				
				System.out.print("* 수정할 국어점수 입력 : ");
				int kor = scan.nextInt();
				System.out.print("* 수정할 영어점수 입력 : ");
				int eng = scan.nextInt();
				System.out.print("* 수정할 수학점수 입력 : ");
				int math = scan.nextInt();
				
				int tot = kor + eng + math;
				double avg = tot / 3.;

				sungJukDTO2.setKor(kor);
				sungJukDTO2.setEng(eng);
				sungJukDTO2.setMath(math);
				sungJukDTO2.setTot(tot);
				sungJukDTO2.setAvg(avg);
				
				break;
			} //if
		} //for
		if(search==0) System.out.println("찾는 이름이 없습니다.");
		else System.out.println("점수가 수정되었습니다.");
		System.out.println();
	}
}
