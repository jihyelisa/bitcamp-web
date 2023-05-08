package board.bean;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
// @Component 하면 무조건 싱글톤으로 생성함
public class BoardDTO {
	private int seq;
	private String name;
	private String subject;
	private String content;
	private Date logtime;
}
