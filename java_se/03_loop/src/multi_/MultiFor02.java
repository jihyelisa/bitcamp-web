package multi_;

public class MultiFor02 {

	public static void main(String[] args) {
		
		for(int dan=2; dan<=9; dan++) {
			for(int num=1; num<=9; num++) {
				System.out.println(dan + " * " + num + " = " + dan*num);
			} //for num
			System.out.println();
		} //for dan
	}
}
