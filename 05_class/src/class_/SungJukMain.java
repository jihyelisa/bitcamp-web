package class_;

public class SungJukMain {
	
	public static void main(String[] args) {
		
		//데이터
		SungJuk sj1 = new SungJuk();
		sj1.setData("홍길동", 91, 95, 100);
		//출력
		for(int i=0; i<60; i++) System.out.print("-");		
		System.out.println("\n이름      국어      영어      수학      총점      평균      학점");
		for(int i=0; i<60; i++) System.out.print("-");
		System.out.print("\n" + sj1.getName() + "\t"
						+ sj1.getKor() + "\t"
						+ sj1.getEng() + "\t"
						+ sj1.getMath() + "\t"
						+ sj1.getTot() + "\t"
						+ sj1.getAvg() + "\t"
						+ sj1.getGrade() + "\t\n");

		//데이터
		SungJuk sj2 = new SungJuk();
		sj2.setData("프로도", 100, 89, 75);
		//출력
		System.out.print("\n" + sj2.getName() + "\t"
						+ sj2.getKor() + "\t"
						+ sj2.getEng() + "\t"
						+ sj2.getMath() + "\t"
						+ sj2.getTot() + "\t"
						+ sj2.getAvg() + "\t"
						+ sj2.getGrade() + "\t\n");

		//데이터
		SungJuk sj3 = new SungJuk();
		sj3.setData("죠르디", 75, 80, 48);
		//출력
		System.out.print("\n" + sj3.getName() + "\t"
						+ sj3.getKor() + "\t"
						+ sj3.getEng() + "\t"
						+ sj3.getMath() + "\t"
						+ sj3.getTot() + "\t"
						+ sj3.getAvg() + "\t"
						+ sj3.getGrade() + "\t\n");
		for(int i=0; i<60; i++) System.out.print("-");		

	}
}

/*
[문제] 성적 처리
- 총점, 평균, 학점을 구하시오
- 평균은 소수이하 2째자리까지 출력

총점 = 국어 + 영어 + 수학
평균 = 총점 / 과목수
학점은 평균이 90 이상이면 'A'
      평균이 80 이상이면 'B'
      평균이 70 이상이면 'C'
      평균이 60 이상이면 'D'
      그외는 'F'
      
클래스명 : SungJuk
필드    : name, kor, eng, math, tot, avg, grade  
메소드   : setData(이름, 국어, 영어, 수학)
          calc() - 총점, 평균, 학점 계산
          getName()
        getKor()
        getEng()
        getMath()
         getTot()
         getAvg()
         getGrade()
         
클래스명 : SungJukMain         

[실행결과]
----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동   90      95      100
----------------------------------------------------
*/