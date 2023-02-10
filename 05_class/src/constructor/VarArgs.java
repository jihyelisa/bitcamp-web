package constructor;

public class VarArgs {
	public VarArgs() {
		System.out.println("기본 생성자");
	}
	
	//...ar을 사용하면 인자 수를 자유롭게 입력 - 자동으로 배열화 됨
	public int sum(int...ar) {
		int hap=0;
		for(int i=0; i<ar.length; i++) {
			hap += ar[i];
		}
		return hap;
	}
	
	public static void main(String[] args) {
		
		VarArgs va = new VarArgs(); //생성자 호출
		System.out.println("합 = " + va.sum(10, 20));
		System.out.println("합 = " + va.sum(10, 20, 30));
		System.out.println("합 = " + va.sum(10, 20, 30, 40));
		
	}

}
