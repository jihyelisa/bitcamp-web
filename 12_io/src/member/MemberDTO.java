package member;

import java.io.Serializable;
import java.util.Comparator;

public class MemberDTO implements Serializable, Comparator<MemberDTO> {
	
	@Override
	public int compare(MemberDTO dto1, MemberDTO dto2) {
		return dto1.getName().compareTo(dto2.getName());
	}

	private String name;
	private int age;
	private String phone, address;
	
	public MemberDTO(String name, int age, String phone, String address) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	
	

}
