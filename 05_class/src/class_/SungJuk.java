package class_;

public class SungJuk {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
	private char grade;
	
	public void setData(String n, int k, int e, int m) {
		name = n;
		kor=k; eng=e; math=m;
	}

	public String getName() {
		return name;
	}
	public int getKor() {
		return kor;
	}
	public int getEng() {
		return eng;
	}
	public int getMath() {
		return math;
	}
	public int getTot() {
		tot = kor+eng+math;
		return tot;
	}
	public String getAvg() {
		avg = (kor+eng+math) / 3.0;
		return String.format("%.2f", avg);
	}
	
	public char getGrade() {
		if(avg>=90) grade='A';
		else if(avg>=80) grade='B';
		else if(avg>=70) grade='C';
		else if(avg>=60) grade='D';
		else grade='F';
		return grade;
	}



}
