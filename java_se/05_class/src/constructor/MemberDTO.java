package constructor;

public class MemberDTO { //Data Transfer Object (VO: Value Object 라고도 함)
	private String name;
	private int age;
	private String phone;
	private String address;
	
	//setter가 아닌 생성자를 통해 데이터 4개를 받아온다.
	public MemberDTO(String name, int age, String phone, String address) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddress(String address) {
		this.address = address;
	}

}
