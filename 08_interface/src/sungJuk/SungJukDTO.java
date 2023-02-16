package sungJuk;

public class SungJukDTO implements Comparable<SungJukDTO> {
	
	private int no;
	private String name;
	private int kor, eng, math, total;
	private double avg;
	
	public SungJukDTO(int no, String name, int kor, int eng, int math) {
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	public void calc() {
		total = kor + eng + math;
		avg = total / 3.0;
	}
	
	//SungJukList 클래스에서 사용할 toString Override
	@Override
	public String toString() {
		return (no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math
				+ "\t" + total +"\t" + avg);
	}
	
	@Override
	//total 기준으로 내림차순
	public int compareTo(SungJukDTO dto) {
		if(this.total > dto.total) return -1; //오른쪽이 크면 -1
		else if(this.total < dto.total) return 1;
		else return 0;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getAvg() {
		return avg;
	}
	public void setAvg(double avg) {
		this.avg = avg;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
