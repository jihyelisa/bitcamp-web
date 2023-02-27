package inheritance;

public class ChildMain extends Super{
	private String name;
	private int age;

	ChildMain() {
		System.out.println("ChildMain 기본 생성자");
	}
	ChildMain(String name, int age, double weight, double height) {
		super(weight, height); //부모 생성자 호출
		
		this.name = name;
		this.age = age;
//		super.weight = weight; //부모 클래스의 참조값(주소) 불러오기
//		this.height = height; //(상속했으므로 this를 써도 상관은 없음)
	}
	
	public void disp() {
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		this.disp(); //다시 이 함수로 돌아오므로 무한루프
		super.disp(); //부모(super) 클래스의 disp()로 감
	}
	
	public static void main(String[] args) {
		SubMain aa = new SubMain("지혜", 25, 39.5, 153.1);
		aa.disp(); //부모 메소드 호출
	}

}
