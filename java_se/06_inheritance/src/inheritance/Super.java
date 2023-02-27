package inheritance;

//모든 클래스는 extends Object를 상속하고 있지만 표기는 생략 가능하다
public class Super extends Object{
	protected double weight, height;
	
	Super() {
		System.out.println("Super 기본 생성자");
	}
	
	Super(double weight, double height) {
		this.weight = weight;
		this.height = height;
	}
	
	public void disp() {
		System.out.println("몸무게 = " + weight);
		System.out.println("키 = " + height);
	}

}
