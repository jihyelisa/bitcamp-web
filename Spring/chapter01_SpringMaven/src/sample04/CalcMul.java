package sample04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CalcMul implements Calc {

	@Override
	public void caculate(int x, int y) {
		System.out.println(x + " * " + y + " = " + x*y);
	}

}
