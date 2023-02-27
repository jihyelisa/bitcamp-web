package inheritance;

class Test extends Object {
	
}

class Sample {
	@Override
	public String toString() {
		return getClass() + "   idiot!";
	}
}

//--------------

class Exam {
	private String name = "Gildong";
	@Override
	public String toString() {
		return super.toString(); //Exam의 부모인 Object의 toString() 가져옴
	}
}

//--------------

public class ObjectMain {  //extends Object는 생략 가능
	
	public static void main(String[] args) {
		Test t = new Test(); //new 생성 - 기본 생성자 호출됨
		
		System.out.println("객체 t = " + t);
		//클래스명@16진수
		System.out.println("객체 t = " + t.toString());
		//위와 똑같은 주소
		//t에 toString()이 없으니 부모 클래스인 Object로 감 -> 있음!
		System.out.println("객체 t = " + t.hashCode());
		//위 주소값의 16진수값이 10진수 해시코드로 변환되어 반환
		System.out.println();

		Sample s = new Sample();
		System.out.println("객체 s = " + s.toString());
		System.out.println();
		
		Exam e = new Exam();
		System.out.println("객체 e = " + e.toString());
		System.out.println();
		
		String aa = "apple";
		System.out.println("객체 aa = " + aa);
		System.out.println("객체 e = " + aa.toString());
		//왜 문자열은 toString 유무와 관계 없이 주소값이 아니라 문자열로 출력될까?
		//String 클래스를 불러오면서 Override 됐기 때문
		System.out.println("객체 t = " + aa.hashCode());
		//믿으면 안 됨! - 문자열은 무한대라 10진수로 표현 불가

		
		
		//Object와 String 클래스의 관계
		
		String bb = new String("apple");
		String cc = new String("apple");
		System.out.println("bb==cc: " + (bb==cc));
		//주소 비교 false
		System.out.println("bb.equals(cc): " + bb.equals(cc));
		//문자열 비교 true
		System.out.println();
		
		Object dd = new Object();
		Object ee = new Object();
		System.out.println("dd==ee: " + (dd==ee));
		//주소 비교 false
		System.out.println("dd.equals(ee): " + dd.equals(ee));
		//주소 비교 false
		//String이 아니므로 문자열 비교 불가, equals 사용시에도 주소를 비교한다.
		System.out.println();
		
		Object ff = new String("apple");
		Object gg = new String("apple");
		System.out.println("ff==gg: " + (ff==gg));
		//주소 비교 false
		System.out.println("ff.equals(gg): " + ff.equals(gg));
		//문자열 비교 true
		//한쪽이 Object인데 왜 문자열 비교가 될까?
		//String 클래스를 불러오면서 equals()가 Override 되기 때문
		System.out.println();
	}
}
