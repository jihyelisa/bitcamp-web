package abstract_;

public class AbstractMain extends AbstractTest {
	
	@Override
	public void setName(String name) {
		this.name = name;
	}

	public static void main(String[] args) {
		AbstractTest at = new AbstractMain();
		//추상클래스는 직접적으로 메모리에 생성(new)
		//반드시 sub클래스에서 Override해야 한다.
		at.setName("홍길동");
		System.out.println(at.getName());
	}
}
