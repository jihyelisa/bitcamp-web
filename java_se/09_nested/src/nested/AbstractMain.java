package nested;

public class AbstractMain {

	public static void main(String[] args) {

		AbstractTest at = new AbstractTest() { //익명 inner 클래스
										//이름 없는 클래스, 한 번만 쓰고 버림
										//상속 없이도 클래스 내에 method를 구현할 수 있음
			public void setName(String name) {
				this.name = name;
			}
		}; //익명 inner 클래스
		
		InterA in = new InterA() { //인터페이스는 new 불가
								   //익명 inner 클래스를 new해서 가능하게 해줌
			public void aa() {}
			public void bb() {}
		};
		
		AbstractExam ae = new AbstractExam() {
			//AbstractExam은 추상 클래스이지만 추상 메소드를 가지고 있지 않음
			//- 필수로 Override 해야 하는 메소드는 없다.
			//- 원하는 메소드만 Override 하면 된다.
		};
	}
}
