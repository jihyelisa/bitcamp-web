package collection;

public class PersonDTO implements Comparable<PersonDTO> {
	
	private String name;
	private int age;
	
	public PersonDTO(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return name + "\t" + age;
	}
	
	@Override
	public int compareTo(PersonDTO dto) {
		//정렬 기준을 정해줌
		//age를 기준으로 오름차순 정렬 한다면
		if(this.age < dto.age) return -1; //오른쪽이 크면 -1
		else if(this.age > dto.age) return 1;
		else return 0;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
}
