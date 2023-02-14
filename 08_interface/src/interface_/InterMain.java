package interface_;

//public class InterMain implements InterA, InterB {
public class InterMain implements InterC {
	//InterA, InterB를 상속하는 InterC 하나만 쓰면 A, B를 모두 사용 가능
	//implements: 인터페이스의 모든 추상메소드를 무조건 Override하겠다는 약속
	//참고) 이 클래스에서 Override 하지 않으려면 abstract 클래스로 만들어 다음 sub 클래스에게 넘기는 방법도 있다.
	
	public void aa() {}
	public void bb() {}
	
	public void cc() {}
	public void dd() {}
	
	public static void main(String[] args) {
		
	}

}
