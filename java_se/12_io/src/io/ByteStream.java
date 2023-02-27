package io;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ByteStream {

	public static void main(String[] args) throws IOException {
		//FileNotFound의 부모인 IOException으로 throws 달아줌
		
		//파일 읽기
		FileInputStream fis = new FileInputStream(new File("data.txt"));
		//File로 파일 객체 생성 -> FileInputStream으로 버퍼에 넘김
		BufferedInputStream bis = new BufferedInputStream(fis);
		int data = bis.read(); //read는 int 형식으로 읽어온다

		while( (data = bis.read()) != -1) System.out.print(data + " ");
//		출력결과: 66 67 68 13 10 49 50 51 52 13 10 43 45 42 47 
//		알파벳은 코드번호 / 숫자는 문자열로 인식한 뒤 코드번호
//		Enter는 13 10: 13(="\n", 다음 줄로 내려가라) 10(="\r", 맨 앞으로 가라)
		
		System.out.println();
		while( (data = bis.read()) != -1) System.out.print((char)data);
	}
}
