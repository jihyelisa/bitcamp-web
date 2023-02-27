package class_;

class Person{
	//필드 선언하면 초기화 없이도 초기값이 들어 있음
	private String name; //null
	private int age; //0
	//private을 사용하면 class 안에서만 그 데이터를 사용할 수 있음
	//class 밖에서 사용하려면? 메소드를 사용해야 함
	
	public void setName(String n) { //구현 형식: public 결과형 메소드명(인수형 인수)
		//결과형이 void인 함수: 결과물이 나오지 않음
		name = n;
	}
	
	public void setAge(int a) {
		age = a;
	}
	
	public void setData(String n, int a) {
		name = n;
		age = a;
	}
	
	//하나의 클래스 안에 이름이 같은 함수를 만들 수 있음 - overload 함수
	//단, () 안에 입력 받는 인수(파라미터, 매개변수)는 달라야 함
	public void setData() {};
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
}


public class PersonMain {
	
	public static void main(String[] args) {
		
		Person a; //객체형 변수 선언
		a = new Person();
		System.out.println("객체 a = " + a);
		a.setName("홍길동");
		a.setAge(25);
		System.out.println("이름 = " + a.getName() + "\t나이 = " + a.getAge());
		
		Person b = new Person(); //객체형 변수를 여러개 선언할 수 있다.
		System.out.println("객체 b = " + b);
		b.setName("코난");
		b.setAge(13);
		System.out.println("이름 = " + b.getName() + "\t나이 = " + b.getAge());

		Person c = new Person();
		System.out.println("객체 c = " + c);
		c.setData("둘리", 100);
		System.out.println("이름 = " + c.getName() + "\t나이 = " + c.getAge());
		
		Person d = new Person();
		System.out.println("객체 d = " + d);
		d.setData();
		System.out.println("이름 = " + d.getName() + "\t나이 = " + d.getAge());
		//결과: 이름 = null	나이 = 0
		//함수가 아무런 기능을 포함하고 있지 않지만 Person 클래스에 저장된 초기값을 가져옴
		
	}

}
