package multi;

public class MultiArray02 {

	public static void main(String[] args) {
		
		int[][] ar = new int[10][10];
		int num = 0;
		
//		//입력 1
//				for(int i=0; i<ar.length; i++) {
//					for(int j=0; j<ar[i].length; j++) {
//						num++;
//						ar[i][j] = num;
//					} //for j
//				} //for i
				
				
//		//입력 2
//		for(int i=0; i<ar.length; i++) {
//			for(int j=0; j<ar[i].length; j++) {
//				num++;
//				ar[j][i] = num;
//			} //for j
//		} //for i
		
		
		//입력 3 - 내가 쓴 코드
		for(int i=ar.length; i<ar.length; i--) {
			for(int j=ar[0].length; j<ar[i].length; j--) {
				num++;
				ar[i][j] = num;
			} //for j
		} //for i
		
		//입력 3 - 선생님 코드
		for(int i=ar.length-1; i>=0; i--) {
			for(int j=ar[i].length-1; j>=0; j--) {
				num++;
				ar[i][j] = num;
			} //for j
		} //for i

				
			
		//출력
		for(int i=0; i<ar.length; i++) {
			for(int j=0; j<ar[i].length; j++) {
				System.out.print(String.format("%4d", ar[i][j]));
			} //for j
		} //for i
	}
}
