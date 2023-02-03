package for_;

public class For03 {

	public static void main(String[] args) {
		int i, sum=0, mul=1;
		
//		i=1;
//		sum = sum + 1; //1
//		i=2;
//		sum = sum + 2; //3
//		i=3;
//		sum = sum + 3; //6
//      ...
//		sum = sum + 10; //55
		
		for(i=1; i<=10; i++) {
			sum += i;
			mul *= i;
			System.out.println(i + "\t" + sum + "\t" + mul);
		} //for
	}
}
