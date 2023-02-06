package array;

public class Array01 {
	
	public static void main(String[] args) {
		
		int[] ar;
		ar = new int[5];
		System.out.println("배열명 ar = " + ar);

		ar[0] = 25;
		ar[1] = 37;
		ar[2] = 55;
		ar[3] = 42;
		ar[4] = 30;
		
		System.out.println("배열 크기 =  " + ar.length + "\n"); //5

		for(int i=0; i<ar.length; i++) {
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
		
		System.out.println();
		System.out.println("거꾸로 출력");
		for(int i=(ar.length-1); i>=0; i--) {
			System.out.println("ar[" + i + "] = " + ar[i]);
		}
		
		System.out.println();
		System.out.println("홀수 데이터만 출력");
		for(int i=0; i<ar.length; i++) {
			if(ar[i]%2==1) System.out.println("ar[" + i + "] = " + ar[i]);
		}
		
		System.out.println();
		System.out.println("확장형 for문");
		for(int data : ar) { //.length 없이도 배열 ar의 크기만큼 알아서 for문을 반복함
			System.out.println(data); //번호 표기 없이도 내용물을 바로 전달해줌
		}
		
	}

}
