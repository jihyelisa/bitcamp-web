package inheritance;

enum Color { //enum은 상수들의 집합체
	RED, GREEN, BLUE //세미콜론은 생략가능
}

class Final {
	
	//컴퓨터가 인식하는 값은 0, 1, 2
	//사람이 보기 편하게 숫자에 이름을 부여한 것
//	public static final int RED = 0;
//	public static final int GREEN = 1;
//	public static final int BLUE = 2;

	public final String FRUIT = "apple";
	public final String FRUIT2;
	//생성자에서 초기값 줄 수 있음 (항상 new하고 사용할 것이므로)

	public static final String ANIMAL =  "giraffe";
	public static final String ANIMAL2;
	//static은 실행하자마자 메모리에 자동으로 생성 - new 쓸 필요 없음
	//생성자에서 초기값 못 줌 (new 없이도 사용할 수 있으므로)
	
	static {
		System.out.println("**static initializing area");
		ANIMAL2 = "elephant";
	}
	
	public Final() {
		System.out.println("**default constructor");
		FRUIT2 = "strawberry"; //생성자에서 초기값 부여
	}
}

public class FinalMain {

	public static void main(String[] args) {
		System.out.println();
		System.out.println("RED = " + Color.RED);
		System.out.println("RED.ordinal() = " + Color.RED.ordinal());
		for(Color data : Color.values()) {
			System.out.println(data + "\t" + data.ordinal());

		final int A = 10;
//		A =20; //에러 - final 상수는 값을 변경할 수 없음
		System.out.println("A = " + A);
		
		final int B;
		B =20; //에러 - final 상수는 값을 변경할 수 없음
		System.out.println("B = " + B);
		
		Final f = new Final();
		System.out.println("FRUIT = " + f.FRUIT);
		System.out.println("FRUIT2 = " + f.FRUIT2);

		//static은 new 사용 x
		System.out.println("ANIMAL = " + Final.ANIMAL);
		System.out.println("ANIMAL2 = " + Final.ANIMAL2);
		}
	}
}
