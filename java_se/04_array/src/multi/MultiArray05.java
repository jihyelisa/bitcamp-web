package multi;

import java.util.Scanner;

public class MultiArray05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//자료형별 배열 선언
		System.out.print("인원수: ");
		int cnt = scan.nextInt();
		String[] name = new String[cnt];
		String[][] subject = new String[cnt][];
		int[][] jumsu = new int[cnt][];

		//인원수만큼 전체 입력 반복
		for(int i=0; i<cnt; i++) {
			
			System.out.print("이름 입력: ");
			name[i] = scan.next();
			
			//가변 길이 배열을 포함하는 다차원 배열
			System.out.print("과목수 입력: ");
			int subjectCnt = scan.nextInt();
			subject[i] = new String[subjectCnt];
			jumsu[i] = new int[subjectCnt];
			
			//과목 수만큼 과목명 입력 반복
			for(int j=0; j<subjectCnt; j++) {
				System.out.print("과목명 입력: ");
				subject[i][j] = scan.next();
			}

			//과목 수만큼 점수 입력 반복
			for(int j=0; j<subjectCnt; j++) {
				System.out.print(subject[i][j] + " 점수 입력: ");
				jumsu[i][j] = scan.nextInt();
			}
			System.out.println("---------------------");
		} //for i
		
		
		
		//인원수만큼 성적표 전체 출력 반복
		for(int i=0; i<name.length; i++) {
			//총점, 평균 변수 선언
			int tot=0;
			String avg;
			
			//인덱스
			System.out.print("이름\t");
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(subject[i][j] + "\t");
			}
			System.out.print("총점\t평균");
			
			//내용
			System.out.print("\n" + name[i] + "\t");
			for(int j=0; j<subject[i].length; j++) {
				System.out.print(jumsu[i][j] + "\t");
				tot += jumsu[i][j]; //총점 계산
			} //for j
			avg = String.format("%.2f", (double)tot / subject[i].length); //평균 계산
			System.out.print(tot + "\t" + avg + "\n\n");
		} //for i
	}
}

/*
인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
평균은 소수이하 2째자리까지 출력

[실행결과]
인원수 : 2 (cnt)

이름입력 : 홍길동 (name)
과목수 입력 : 2   (subjectCnt)
과목명 입력 : 국어 (subject)
과목명 입력 : 영어
국어 점수 입력 : 95 (jumsu)
영어 점수 입력 : 100
---------------------
이름입력 : 이기자
과목수 입력 : 3
과목명 입력 : 국어
과목명 입력 : 영어
과목명 입력 : 과학
국어 점수 입력 : 95
영어 점수 입력 : 100
과학 점수 입력 : 90
---------------------

이름     국어     영어   총점     평균
홍길동    95     100   xxx     xx.xx

이름      국어  영어   과학    총점      평균
이기자   95   100   90    xxx      xx.xx
*/