package member;

public class MemberMain {

	public static void main(String[] args) {
		MemberService memberService = new MemberService();
		memberService.menu();      
		System.out.println("프로그램을 종료합니다.");
	}

}

/*
[문제] 회원관리

* 조건
- 회원의 정보는 이름, 나이, 핸드폰, 주소로 한다.
- 회원의 데이터를 입력받아서 파일에 저장하거나 파일의 내용을 읽어온다.
- 메뉴를 작성한다.
  메뉴에 따라 각각의 클래스를 작성한다.

1. 인터페이스 작성

Member.java
- 추상메소드 public void execute(~~~);

2. 클래스 작성
① MemberMain.java

② MemberService.java
- 메뉴 작성

menu()
********************
  1. 등록
  2. 출력
  3. 핸드폰 검색
  4. 이름으로 오름차순
  5. 파일 저장
  6. 파일 읽기
  7. 끝
********************
  번호 : 

③ MemberDTO.java
- 필드, 생성자, setter, getter

④ MemberInsert.java

이름 입력 :
나이 입력 :
핸드폰 입력 :
주소 입력 : 

⑤ MemberPrint.java

이름		나이	핸드폰			주소
홍길동	25	010-1234-1234	서울
프로도	30	010-1111-2222	부산

⑥ MemberPhoneSearch.java

검색할 핸드폰 입력 : 010-1234-1234

이름		나이	핸드폰			주소
홍길동	25	010-1234-1234	서울

⑦ MemberNameAsc.java

이름		나이	핸드폰			주소
프로도	30	010-1111-2222	부산
홍길동	25	010-1234-1234	서울

⑧ MemberFileInput.java
⑨ MemberFileOutput.java





*/













