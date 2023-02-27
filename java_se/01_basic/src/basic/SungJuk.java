package basic;

public class SungJuk {

	public static void main(String[] args) {
		char name;
		name = 'L';
		
		int kor;
		kor = 85;
		
		int eng;
		eng = 78;
		
		int math;
		math = 100;
		
		float tot;
		tot = kor + eng + math;
		
		float avg;
		avg = tot / 3;
		
		System.out.println("   *** " + name + " 성적표 ***");
		System.out.println("국어\t영어\t수학\t총점\t평균");
		System.out.println(kor + "\t" + eng + "\t" + math + "\t" + String.format("%.0f", tot) + "\t" + String.format("%.2f", avg));

	}

}


/*
[문제] 성적계산
이름(name)이 L이고 국어점수(kor) 85, 영어점수(eng) 78, 수학점수(math) 100일 때 총점(tot)과 평균(avg)을 구하시오
단, 평균은 소수 이하 2째자리까지 출력하시오.
\t 사용해서 옆으로 간격 넣기

총점 = 국어 + 영어 + 수학
평균 = 총점 / 과목수

[실행결과]
   *** L 성적표 ***
국어      영어      수학      총점      평균
85      78      100      xxx      xx.xxx
*/