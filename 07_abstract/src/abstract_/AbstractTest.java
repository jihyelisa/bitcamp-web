package abstract_;

public abstract class AbstractTest { //POJO 형식 (Plain Old Java Object)
	
	protected String name;
	
	public AbstractTest() {
		// TODO Auto-generated constructor stub
	}

	public AbstractTest(String name) {
		super();
		this.name = name;
	}
	

	public String getName() { //구현
		return name;
	}
	
	public abstract void setName(String name); //추상메소드
	//클래스 안에 추상 메소드가 있으면 클래스도 추상 클래스여야 한다.
	

}
