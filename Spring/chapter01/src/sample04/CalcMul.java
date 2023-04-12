package sample04;

public class CalcMul implements Calc {

	@Override
	public void caculate(int x, int y) {
		System.out.println(x + " * " + y + " = " + x*y);
	}

}
