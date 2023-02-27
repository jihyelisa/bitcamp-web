package inheritance;

public class SubMain extends Super {
	private String name;
	private int age;

	SubMain() {
		System.out.println("SubMain 기본 생성자");
	}
	SubMain(String name, int age, double weight, double height) {
		this.name = name;
		this.age = age;
		super.weight = weight; //부모 클래스의 참조값(주소) 불러오기
		this.height = height; //(상속했으므로 this를 써도 상관은 없음)
	}
	
	public void output() {
		System.out.println("이름 = " + name);
		System.out.println("나이 = " + age);
		disp(); //부모 메소드 바로 가져다 쓸 수 있음
	}
	
	public static void main(String[] args) {
		SubMain aa = new SubMain("지혜", 25, 39.5, 153.1);
		aa.disp(); //부모 메소드 호출
		System.out.println("----------");
		aa.output(); //자식 메소드 호출
		System.out.println("----------");
		
		Super bb = new SubMain("코난", 13, 53.3, 140.6);
//		bb.output(); //이건 에러 - bb가 SubMain이 아닌 Super를 가리키고 있으므로
		bb.disp();
	}
}

//자식 클래스 메모리 new 생성할 때
//- 부모 클래스 생성
//- 자식 클래스 생성
//총 두 개를 생성한다.
//= 생성자는 new 생성할 때마다 불러오므로 생성자 두 번 호출