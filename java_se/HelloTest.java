class HelloTest {
	public static void main(String[] args){
		System.out.print("�ȳ��ϼ���\n");
		System.out.print("�ݰ����ϴ�\n");
		System.out.println(25 + 3);
		System.out.println("25 + 3");
		System.out.println("25" + "3");
		System.out.println("25 + 3 = " + 25 + 3);
		System.out.println("25 + 3 = " + (25 + 3));
		System.out.println("25 / 3 = " + (25 / 3));  // ���� / ����
		System.out.println("25 / 3 = " + (25.0 / 3));  // �Ǽ� / ����
		System.out.println("25 / 3 = " + String.format("%4.2f", 25.0 / 3));  // �Ҽ� ���� ��° �ڸ�
		System.out.println("25 / 3 = " + String.format("%.2f", 25.0 / 3));  // ��ü �ڸ����� ��������
	}
}