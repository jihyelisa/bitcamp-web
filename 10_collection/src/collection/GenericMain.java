package collection;

class GenericTest<T> {
	private T a; //Generic 타입 T
	
	public void setA(T a) {
		this.a = a;
	}
	public T getA() {
		return a;
	}
}

public class GenericMain {
	
	public static void main(String[] args) {
		GenericTest<String> aa = new GenericTest<String>();
		aa.setA("홍길동");
		System.out.println("이름 = " + aa.getA());
		
		//aa.setA(25);
		GenericTest<Integer> bb = new GenericTest<Integer>();
		bb.setA(25);
		System.out.println("나이 = " + bb.getA());
		
	}
}