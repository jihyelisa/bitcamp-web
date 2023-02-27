package class_;

public class Compute {
	
	private int x, y, sum, sub, mul;
	private double div;
	
	
	public void setData(int x, int y) {
		//this.를 붙이면 클래스의 x, y
		//(평소에는 생략가능, 이 경우 지역변수와 헷갈리므로 표기)
		//붙이지 않은 x, y는 지역변수, 필드
		this.x=x;
		this.y=y;
	}
	public void calc() {
		sum = x+y;
		sub = x-y;
		mul = x*y;
		div = (double)x/y;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getSum() {
		return sum;
	}
	public int getSub() {
		return sub;
	}
	public int getMul() {
		return mul;
	}
	public String getDiv() {
		return String.format("%.2f", div);
	}
	
	

}


/*
[문제] 사칙연산
x, y를 입력하여 합, 차, 곱, 몫을 구하시오

클래스명 : Compute (1인분)
필드 : x, y, sum, sub, mul, div
메소드 : setData(x의 값, y의 값)
        calc()
        getX()
        getY()
        getSum()
        getSub()
        getMul()
        getDiv()
        
클래스명 : ComputeMain        

[실행결과]
횟수 입력 : 2

[1번째]
x 입력 : 25
y 입력 : 36

[2번째]
x 입력 : 35
y 입력 : 12

x   y   sum      sub      mul      div
25   36
35   12
*/