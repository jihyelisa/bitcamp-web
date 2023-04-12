package sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

//@Component
public class CalcMul implements Calc {
	private int x, y;

	//@Autowired - 생성자가 아닌 메소드에 걸면 실행시 생성자처럼 자동으로 실행
	@Autowired
	public void setX(@Value("25") int x) {
		this.x = x;
	}
	@Autowired
	public void setY(@Value("36") int y) {
		this.y = y;
	}
	
	@Override
	public void calculate() {
		System.out.println(x + " * " + y + " = " + (x*y));
	}
}
