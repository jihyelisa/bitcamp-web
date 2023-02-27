package class_;

class This {
	private int b;
	private static int c;
	
	//구현, 인수(argument), 매개변수(parameter)
	public void setB(int b) {
		System.out.println("this = " + this);
		this.b = b;
	}
	public int getB() {
		return b;
	}
	public void setC(int c) {
		this.c = c;
	}
	public int getC() {
		return c;
	}
}

public class ThisMain {
	private int a; //필드
	
	//static 영역에서는 this 사용하지 않는다.
	public static void main(String[] args) {
		//모든 클래스는 반드시 생성(new)해야 사용할 수 있다.
		ThisMain tm = new ThisMain();
		tm.a = 10; //private 필드인데 왜 접근 가능? 같은 클래스 안이므로
		System.out.println("a = " + tm.a);
		
		This t = new This();
		t.setB(20); //호출
		System.out.println("t.b = " + t.getB());
		
		//이건 왜 안 될까? private 필드인데 같은 class 안에 있지 않으므로
//		This.c = 30;
		//이건 왜 안 될까? c는 static이지만 setC 메소드는 static이 아니므로
//		This.setC(30);
		t.setC(30);
		System.out.println("t.c = " + t.getC());
		
		This w = new This();
		w.setB(40);
		w.setC(50);
		System.out.println("w.b = " + w.getB());
		System.out.println("w.c = " + w.getC());
		
	}

}
