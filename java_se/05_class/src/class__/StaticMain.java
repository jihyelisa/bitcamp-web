package class__;


class StaticTest {
	private int a; //필드, 초기화, 인스턴스 변수
	private static int b; //필드, 클래스 변수
	
	static {
		System.out.println("초기화 영역");
//		this.b = 7; //에러
		StaticTest.b = 5;
	}
	public StaticTest() {
		System.out.println("기본 생성자");
		this.a = 5;
	}
	
	public void calc() {
		a++;
		b++;
	}
	
	public void disp() {
		System.out.println("a = " + a + " b = " + b);
	}
	
	public static void output() {
		System.out.println("Static method...");
		
		//에러 - static 메소드 안에서는 static 변수만 사용 가능	
//		System.out.println("a = " + a + " b = " + b);
	}
}
	
public class StaticMain {
	public static void main(String[] args) {
		StaticTest aa = new StaticTest();
		//static 영역은 클래스 생성과 동시에 메모리 안 static 공간에 생성됨
		aa.calc();
		aa.disp();
		
		StaticTest bb = new StaticTest();
		//a는 새로운 클래스 영역에 새로운 a가 생성되지만
		//static 필드인 b는 메모리상 static 영역에 단 한 번만 생성되므로
		//초기화되지 않고 clac()에 의해 계속 증가한다.
		bb.calc();
		bb.disp();
		
		StaticTest cc = new StaticTest();
		cc.calc();
		cc.disp();
		
		StaticTest.output(); //static 메소드이므로 클래스명.메소드() 형식도 가능
		aa.output(); //객체.메소드()
		}
}