package io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataStream {
	
	public static void main(String[] args) {
		try {
//			DataOutputStream dos = new DataOutputStream(new FileOutputStream("result.txt"));
			
			FileOutputStream fos = new FileOutputStream("result.txt");
			DataOutputStream dos = new DataOutputStream(fos);

			dos.writeUTF("홍길동");
			dos.writeInt(25);
			dos.writeDouble(185.3);
			
			dos.close();
			
			//파일 읽기
			FileInputStream fis = new FileInputStream("result.txt");
			DataInputStream dis = new DataInputStream(fis);
			String name = dis.readUTF();
			int age = dis.readInt();
//			float height = dis.readFloat();
			//파일 만들 때의 데이터 형식 그대로 읽지 않으면 데이터 깨짐 
			double height = dis.readDouble();

			System.out.println("이름 = " + name);
			System.out.println("나이 = " + age);
			System.out.println("키 = " + height);
			
		
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
