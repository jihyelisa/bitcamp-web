package nested; //중첩 - 클래스 안에 클래스, 상속관계가 아님

public class Outer {
	private String name;
	
	public void output() {
		Inner in = new Inner();
		System.out.println("이름 = " + this.name + "\t나이 = " + in.age);
		//name은 Outer.가 생략된 셈, age는 this.가 생략된 셈
	}
	
	class Inner { //Inner는 Outer 요소에 자유롭게 접근 가능 - 같은 클래스 안에서만 (main 등에서는 불가)
		private int age;
		
		public void disp() {
			System.out.println("이름 = " + Outer.this.name + "\t나이 = " + this.age);
			//Inner와 Outer는 상속관계가 아니므로, name에는 this. 쓸 수 없음
		}
	}
	
	public static void main(String[] args) {
		
		//main에서 Inner 클래스를 사용하려면?
		Outer ou = new Outer();
		ou.name = "홍길동";
		System.out.println("이름 = " + ou.name);

		Outer.Inner in2 = ou.new Inner();
		in2.age = 25;
		in2.disp();
		
		Outer.Inner in3 = ou.new Inner();
		in2.age = 30;
		in2.disp();
		
		Outer.Inner in4 = new Outer().new Inner();
//		in4.name = "코난"; //같은 클래스(Outer) 안에 있지 않을 때는 Inner여도 Outer에 접근 불가
		in4.age = 35;
		in4.disp();
	}

}
