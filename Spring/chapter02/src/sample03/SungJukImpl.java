package sample03;

import java.util.Scanner;

public class SungJukImpl implements SungJuk {
	private SungJukDTO sungJukDTO;
	
	public SungJukImpl(SungJukDTO sungJukDTO) {
		this.sungJukDTO = sungJukDTO;
	}
	
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
		
//		System.out.println(sungJukDTO.getName()+"\t"+
//						   sungJukDTO.getKor()+"\t"+
//						   sungJukDTO.getEng()+"\t"+
//						   sungJukDTO.getMath()+"\t"+
//						   sungJukDTO.getTot()+"\t"+
//						   sungJukDTO.getAvg());
		//위처럼 쓰는 대신에 DTO에서 toString() 메소드를 Override 함
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
