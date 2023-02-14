package class__;

//import static java.lang.Math.*; //wild card
import static java.lang.Math.random;
import static java.lang.Math.pow;
import static java.lang.String.format;
import static java.lang.System.out;

//밑에서 Math.random()이라고 쓰는 대신
//import static으로 static에 관련된 것만 import해놓고 시작
//선생님은 사용 비추천

public class ImportStatic {
	
	public static void main(String[] args) {
		out.println(random());
		out.println(pow(2, 5));
		out.println(format("%.2f", 45.5678));
	}

}
