package multi;

public class MultiArray03 {
	
	public static void main(String[] args) {
		
		String[] name = {"홍길동", "프로도", "죠르디"};
		int[][] jumsu = {{91,95,100,0}, {100,88,75,0}, {75,80,48,0}};
		double[] arg = new double[3];
		char[] grade = new char[3];
		
		//총점 계산
		for(int j=0; j<jumsu.length; j++) {
			for(int i=0; i<3; i++) {
			jumsu[j][3] += jumsu[j][i];
			}
		}

		for(int i=0; i<arg.length; i++) {
			//평균 계산
			arg[i] = jumsu[i][3] / 3.0;
			
			//학점 계산
			if(arg[i]>=90) grade[i] = 'A';
			else if(arg[i]>=80) grade[i] = 'B';
			else if(arg[i]>=70) grade[i] = 'C';
			else if(arg[i]>=60) grade[i] = 'D';
			else grade[i] = 'F';
		}
		
		
		
		//출력
		for(int i=0; i<60; i++) System.out.print("-");		
		System.out.println("\n이름      국어      영어      수학      총점      평균      학점");
		for(int i=0; i<60; i++) System.out.print("-");
		System.out.println();
		
		for(int i=0; i<3; i++) {
			
			//이름 출력
			System.out.print(name[i] + "\t");
			//점수 출력
			for(int j=0; j<3; j++) System.out.print(jumsu[i][j] + "\t");
			//총점 출력
			System.out.print(jumsu[i][3]);
			//평균 출력
			System.out.print("\t" + String.format("%.2f", arg[i]));
			//학점 출력
			System.out.print("\t" + grade[i]);
			System.out.println();
		}

		for(int i=0; i<60; i++) System.out.print("-");
	}

}

/*
[문제] 성적 처리
- 총점, 평균, 학점을 구하시오
- 평균은 소수 이하 둘째자리까지 출력

총점 = 국 + 영 + 수
평균 = 총점 / 과목수

학점기준
평균 90 이상 A
평균 80 이상 B
평균 70 이상 C
평균 60 이상 D
그 외 F

----------------------------------------------------
이름      국어      영어      수학      총점      평균      학점
----------------------------------------------------
홍길동   90      95      100
프로도   100      89      75
죠르디   75      80      48
----------------------------------------------------
*/