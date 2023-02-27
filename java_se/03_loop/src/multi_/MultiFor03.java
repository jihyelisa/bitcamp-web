package multi_;

public class MultiFor03 {

	public static void main(String[] args) {
		
			for(int num=1; num<=9; num++) {
				for(int dan=2; dan<=9; dan++) {
				System.out.print(dan + " * " + num + " = " + dan*num + "\t");
			} //for num
			System.out.println();
		} //for dan
	}
}
