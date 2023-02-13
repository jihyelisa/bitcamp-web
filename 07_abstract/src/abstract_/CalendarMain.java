package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

class CalendarEx {
	Scanner scan = new Scanner(System.in);
	String year, month;
	int firstDay, lastDay;
	
	public CalendarEx() {
		System.out.print("년도 입력: ");
		year = scan.next();
		System.out.print("월 입력: ");
		month = scan.next();
		System.out.println();
	}
	
	public void calc() throws ParseException {
		
		//String -> Date 형변환해서 Date 객체인 date에 저장
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		Date date = sdf.parse(year + month);
		
		//Calendar 객체 cal의 날짜를 date에 맞춤
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		
		//cal에 set된 월의 요일과 날짜 구하기
		//1. 매달 1일의 요일
		firstDay = cal.get(Calendar.DAY_OF_WEEK); //일요일이 1로 되어 있음
		//2. 매달 마지막 날짜
		lastDay = cal.getActualMaximum(Calendar.DATE);
	}

	public void display() {
		System.out.println("일\t월\t화\t수\t목\t금\t토");
		
		//첫 요일 전까지 빈칸
		for(int j=0; j<firstDay-1; j++) System.out.print("\t");
		//일자 출력
		for(int i=1; i<=lastDay; i++) {
			System.out.print(i + "\t");
			if((firstDay-1+i) % 7 == 0) System.out.println(); //7일마다 줄바꿈
		} //for i
	}
}

public class CalendarMain {
	
	public static void main(String[] args) throws ParseException {
		CalendarEx calEx = new CalendarEx();
		calEx.calc();
		calEx.display();
	}
}


/*
[문제] 만년달력
- 년도, 월을 입력하여 달력을 작성하시오

         
클래스명: CalendarEx
필드: 알아서
- 기본생성자 : 월, 일 입력
- 메소드 : calc() -> 매달 1일의 요일이 무엇인지? (Calendar에 메소드 있음)
                -> 매달 마지막이 28, 29, 30, 31 무엇인지? (Calendar에 메소드 있음)
         display() -> 출력


클래스명: CalendarMain
[실행결과]
년도 입력 : 2002
월 입력 : 10

 일	 월	 화	 수	 목	 금	 토
		 1	 2	 3	 4	 5
 6	 7	 8	 9	10	11	12
13	14	15	16	17	18	19
20	21	22	23	24	25	26
27	28	29	30	31
*/