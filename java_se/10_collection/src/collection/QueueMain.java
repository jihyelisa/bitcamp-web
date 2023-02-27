package collection;

import java.util.LinkedList;
import static java.lang.System.out;

public class QueueMain {
	
	public static void main(String[] args) {
		
		String[] item = {"소나타", "렉스톤", "재규어"};
		LinkedList<String> q = new LinkedList<String>();
		//LinkedList는 먼저 들어간 순서대로 먼저 나온다.
		
		for(String n : item) q.offer(n); //요소 추가
		
		out.println("q의 크기: " + q.size() + "\n");
		String data = "";
		
		while( (data = q.poll()) != null ) {
			out.println(data + " deleted!");
			out.println("q의 크기: " + q.size() + "\n");
		} //while
	}

}
