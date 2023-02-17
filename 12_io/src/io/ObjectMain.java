package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectMain {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//Serializable: 객체 직렬화
		//Stream을 타고 데이터를 이동시킬 때 객체를 보내는 것은 불가
		//byte 단위로 쪼개어(직렬화) 넘겨줬다가 다시 객체화 함
		
		
		//객체 데이터를 파일에 저장하기
		PersonDTO dto = new PersonDTO("홍길동", 25, 185.3);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("result2.txt"));
		oos.writeObject(dto);
		oos.close();
		
		
		//저장한 파일 안 객체 다시 불러오기
		FileInputStream fis = new FileInputStream(new File("result2.txt"));
		ObjectInputStream ois = new ObjectInputStream(fis); //객체를 가져옴
		
		//Stream을 타고 이동할 때는 PersonDTO형이 아닌 Object 타입으로 움직임
		//Object->PersonDTO 캐스팅
		PersonDTO data = (PersonDTO)ois.readObject();
		
		System.out.println("이름 = " + data.getName());
		System.out.println("나이 = " + data.getAge());
		System.out.println("키 = " + data.getHeight());
	}
}
