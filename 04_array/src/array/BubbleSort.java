package array;

public class BubbleSort {
	
	public static void main(String[] args) {
		
		int[] ar = {32, 40, 25, 78, 56};
			
		//sort 하기 전
		for(int i=0; i<ar.length; i++) {
			System.out.print(String.format("%4d", ar[i]));
			//각각 네 자리씩 차지하도록 format 설정
		}
		System.out.println();
		
		
		
		//정렬
		//오름차순(ASCENDING)
		//내림차순(DESCENDING)
		
		int temp;
		for(int i=0; i<(ar.length-1); i++) {
		//마지막 남은 값은 저절로 남은 자리로 갈 것이므로 length-1로 한 번 빼줌
			for(int j=0; j<(ar.length-1)-i; j++) {
			//이렇게 비교하며 하나씩 정렬
			//ar[0] ar[1]  //ar[0] ar[1]  //ar[0] ar[1]  //ar[0] ar[1]
			//ar[1] ar[2]  //ar[1] ar[2]  //ar[1] ar[2]
			//ar[2] ar[3]  //ar[2] ar[3]
			//ar[3] ar[4]
				
				if(ar[j] < ar[j+1]) {
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
					
				} //if
			} //for j
		} //for i
		
		//sort 한 후
		for(int i=0; i<ar.length; i++) {
			System.out.print(String.format("%4d", ar[i]));
			//각각 네 자리씩 차지하도록 format 설정
		}
	}

}
