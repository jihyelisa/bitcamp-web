package com.zoo;

public class Zoo {

	public void tiger() {
		System.out.println("무서운 호랑이");
	}
	protected void giraffe() {
		System.out.println("목이 긴 기린");
	}
	void elephant() { //default - public이 아니므로 다른 영역에서 사용 불가
		System.out.println("뚱뚱한 코끼리");
	}
	private void lion() {
		System.out.println("멋진 사자");
	}

}
