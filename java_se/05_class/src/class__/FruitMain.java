package class__;

class Fruit {
	private String pum;
	private int jan, feb, mar;
	private int tot;
	//데이터 입력 시마다 누적할 것이므로 static 선언
	private static int sumJan, sumFeb, sumMar;
	
	//품목별 데이터 입력 받을 생성자
	public Fruit(String pum, int jan, int feb, int mar) {
		this.pum = pum;
		this.jan = jan;
		this.feb = feb;
		this.mar = mar;

		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
	}
	
	//tot 계산 메소드
	public void calcTot() {
		tot = jan + feb + mar;
	}
	//데이터 표 내용 출력 메소드
	public void display() {
		System.out.println(pum + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
	}
	//월별 합계 출력 메소드
	//static 필드 사용할 것이므로 static 메소드로 작성
	public static void output() {
		System.out.println("\t" + sumJan + "\t" + sumFeb + "\t" + sumMar);
	}
}


public class FruitMain {
	
	public static void main(String[] args) {
		//표 인덱스 출력
		System.out.println("-------------------------------------");
		System.out.println("PUM\tJAN\tFEB\tMAR\tTOT");
		System.out.println("-------------------------------------");
		
		//객체 배열 생성해 데이터 입력
		Fruit[] fruitArray = new Fruit[3];
		fruitArray[0] = new Fruit("사과", 100, 80, 75);
		fruitArray[1] = new Fruit("포도", 30, 25, 10);
		fruitArray[2] = new Fruit("딸기", 25, 30, 90);
		
		//확장형 for문으로 배열 안 객체별 메소드 실행
		for(Fruit data : fruitArray) {
			data.calcTot();
			data.display();
		}
		//output 메소드로 월별 합계가 누적된 static 필드 출력
		System.out.println("-------------------------------------");
		Fruit.output();
	}

}

/*
과일 판매량 구하기
월별 매출합계도 구하시오

Scanner 사용 x, 데이터 직접 넣기

클래스 : Fruit
필드:
pum, jan, feb, mar, tot
sumJan, sumFeb, sumMar
메소드:
생성자(품명, 1월, 2월, 3월)
calcTot()
display()
public static void output()

클래스 : FruitMain

[실행결과]
---------------------------------
PUM      JAN   FEB   MAR      TOT
---------------------------------
사과    100    80    75     255
포도     30    25    10     xxx
딸기     25    30    90     xxx
---------------------------------
       155   135   175            output()로 처리
*/