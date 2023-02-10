package inheritance;

class AA {
	public int a =3;
	public void disp() {
		a += 5;
		System.out.println("AA : " + a + " ");
	}
}

class BB extends AA {
	public int a = 8; //필드는 오버라이드 x
	
	public void disp() { //메소드가 오버라이드 되는 것
		this.a += 5;
		System.out.println("BB : " + a + " ");
	}
}

public class OverrideMain {
	
	public static void main(String[] args) {
		BB aa = new BB();
		aa.disp();
		System.out.println("aa : ");

		AA bb = new AA();
		AA (BB)cc = new AA();
		
		
		AA dd = new AA();
		dd.disp(); //BB: 18
		System.out.println("dd : " + dd.a); //8
		System.out.println();
	}

}
