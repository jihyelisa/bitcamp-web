package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {
	
	public static void main(String[] args) {
		
//		NumberFormat nf = new NumberFormat();
		//에러: NumberFormat은 추상 클래스이므로 new 생성 불가
		//Sub Class 이용하여 메모리에 생성해야 함
		
		//new로 NumberFormat생성
		NumberFormat nf1 = new DecimalFormat();
		System.out.println(nf1.format(12345678.456789));
		System.out.println(nf1.format(12345678));
		System.out.println();
		
		NumberFormat nf2 = new DecimalFormat("#,###.##원");
		//유효숫자가 아닌 것은 표시하지 않음
		System.out.println(nf2.format(12345678.456789));
		System.out.println(nf2.format(12345678));
		System.out.println();
		
		NumberFormat nf3 = new DecimalFormat("#,###.00원");
		//0을 강제로 표시
		System.out.println(nf3.format(12345678.456789));
		System.out.println(nf3.format(12345678));
		System.out.println();
		
		//메소드로 NumberFormat 생성
//		NumberFormat nf4 = NumberFormat.getInstance();
		NumberFormat nf4 = NumberFormat.getCurrencyInstance(); //원 기호 추가
		nf4.setMaximumFractionDigits(2); //최대 소수 이하 둘째자리
		nf4.setMinimumFractionDigits(2); //최소 소수 이하 둘째자리
		System.out.println(nf4.format(12345678.456789));
		System.out.println(nf4.format(12345678));
		System.out.println();
		
		NumberFormat nf5 = NumberFormat.getCurrencyInstance(Locale.US); //달러 기호
		nf5.setMaximumFractionDigits(2);
		nf5.setMinimumFractionDigits(2);
		System.out.println(nf5.format(12345678.456789));
		System.out.println(nf5.format(12345678));
		System.out.println();
		
	}

}
