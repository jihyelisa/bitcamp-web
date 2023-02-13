package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Today {

	//throws로 JVM에게 ParseException 예외처리(에러 났을 때 해결)를 맡김
	public static void main(String[] args) throws ParseException{
		Date date = new Date(); //컴퓨터 시스템의 시간과 날짜 가져옴
		System.out.println("오늘 날짜: " + date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("y년 MM월 dd일 E요일 HH:mm:ss");
		System.out.println("오늘 날짜: " + sdf.format(date));
		System.out.println();
		
		SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
		Date birth = input.parse("19910716091415"); //String -> Date 형변환

		System.out.println("내 생일 = " + birth);
		System.out.println("내 생일 = " + sdf.format(birth));
		System.out.println();
		
//		Calendar cal = new Calendar(); //추상 클래스이기 때문에 new 생성 불가
		//Sub Class 또는 메소드를 이용해 생성해야 함
		Calendar cal1 =  new GregorianCalendar();
		Calendar cal2 = Calendar.getInstance();

		int year = cal1.get(Calendar.YEAR);
		int month = cal1.get(Calendar.MONTH) + 1; //1월이 0으로 되어 있음
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		int week = cal1.get(Calendar.DAY_OF_WEEK); //일요일이 1로 되어 있음
		
		String dayOfWeek=null;
		switch(week) {
		case 1 : dayOfWeek = "일"; break;
		case 2 : dayOfWeek = "월"; break;
		case 3 : dayOfWeek = "화"; break;
		case 4 : dayOfWeek = "수"; break;
		case 5 : dayOfWeek = "목"; break;
		case 6 : dayOfWeek = "금"; break;
		case 7 : dayOfWeek = "토";
		}

		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int minute = cal1.get(Calendar.MINUTE);
		int second = cal1.get(Calendar.SECOND);
		
		System.out.println(year+"년 " + month+"월 " + day+"일 " + dayOfWeek+"요일 "
							+ hour+"시 " + minute+"분 " + second+"초");
	}
}
