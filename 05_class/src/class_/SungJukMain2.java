package class_;

public class SungJukMain2 {
	
	public static void main(String[] args) {
		
		SungJuk[] ar = new SungJuk[3]; //객체 배열 생성
		
		ar[0] = new SungJuk(); //클래스 생성
		ar[0].setData("홍길동", 91, 95, 100); //호출
		
		ar[1] = new SungJuk(); //클래스 생성
		ar[1].setData("프로도", 100, 89, 74); //호출
		
		ar[2] = new SungJuk(); //클래스 생성
		ar[2].setData("죠르디", 75, 80, 48); //호출
		
		
		//출력
		for(int i=0; i<60; i++) System.out.print("-");		
		System.out.println("\n이름      국어      영어      수학      총점      평균      학점");
		for(int i=0; i<60; i++) System.out.print("-");

		for(int i=0; i<ar.length; i++) {
			System.out.print("\n" + ar[i].getName() + "\t"
							+ ar[i].getKor() + "\t"
							+ ar[i].getEng() + "\t"
							+ ar[i].getMath() + "\t"
							+ ar[i].getTot() + "\t"
							+ ar[i].getAvg() + "\t"
							+ ar[i].getGrade() + "\t\n");

		}
		for(int i=0; i<60; i++) System.out.print("-");
	
	}

}
