package sample03;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SungJukImpl implements SungJuk {
	//객체에 Autowired - 생성한 빈 중에서 SungJukDTO를 찾아 값 가져옴
	//빈 생성? xml파일에 작성하거나 @Component, @Bean, @Service, @Repository 사용
	@Autowired
	private SungJukDTO sungJukDTO = null;
	
//	public SungJukImpl(SungJukDTO sungJukDTO) {
//		this.sungJukDTO = sungJukDTO;
//	}
	
	@Override
	public void calcTot() {
		sungJukDTO.setTot(sungJukDTO.getKor() + sungJukDTO.getEng() + sungJukDTO.getMath());
	}

	@Override
	public void calcAvg() {
		sungJukDTO.setAvg(sungJukDTO.getTot() / 3); 
	}

	@Override
	public void display() {
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균");
		System.out.println(sungJukDTO.toString());
		System.out.println();
	}

	@Override
	public void modify() {
		Scanner scan = new Scanner(System.in);
		System.out.print("이름 입력: ");
		sungJukDTO.setName(scan.next());
		System.out.print("국어 입력: ");
		sungJukDTO.setKor(scan.nextInt());
		System.out.print("영어 입력: ");
		sungJukDTO.setEng(scan.nextInt());
		System.out.print("수학 입력: ");
		sungJukDTO.setMath(scan.nextInt());
	}
}
