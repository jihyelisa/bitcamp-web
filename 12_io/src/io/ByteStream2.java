package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream2 {

	public static void main(String[] args) {
		
		try {
			File file = new File("data.txt");
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bis = new BufferedInputStream(fis);
			int size = (int)file.length(); //long은 8byte, int는 4byte
			byte[] b = new byte[size];
			
			//b 배열에 모든 데이터 집어넣음
			bis.read(b, 0, size);
			System.out.println(b); //주소값 출력
			System.out.println(new String(b));
			//byte[]는 기본형, String은 객체형이므로 그냥 형변환 불가, new 해야 함
			
			bis.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
