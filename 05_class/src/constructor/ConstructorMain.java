package constructor;

public class ConstructorMain {
	private String name;
	private int age;
	
	//생성자도 메소드처럼 overload가 가능하다.
	//(이름이 클래스와 같아야 하므로 overload로만 만들 수 있을 듯?)
	public ConstructorMain() {
		System.out.println("default 생성자");
	}
	
	public ConstructorMain(String name) {
		//일반 함수(void main 등)는 생성자를 new하지 않고 호출할 수 없지만
		//생성자는 다른 생성자를 바로 호출할 수 있다.
		//단, 생성자 내 첫 줄에서 호출되어야 한다.
		this(); //생성자 내에서 다른 overload 생성자 호출
		
		System.out.println("생성자");
		this.name = name;
	}
	
	public ConstructorMain(int age) {
		this("코난"); //생성자 내에서 다른 overload 생성자 호출
		
		System.out.println("생성자");
		this.age = age;
	}
	
	
	
	public static void main(String[] args) {
		ConstructorMain aa = new ConstructorMain();
		System.out.println(aa.name + "\t" + aa.age + "\n");

		ConstructorMain bb = new ConstructorMain("홍길동");
		System.out.println(bb.name + "\t" + bb.age + "\n");
		
		ConstructorMain cc = new ConstructorMain(30);
		System.out.println(cc.name + "\t" + cc.age + "\n");
	}
}
