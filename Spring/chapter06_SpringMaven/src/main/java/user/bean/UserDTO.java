package user.bean;

import lombok.Getter;
import lombok.Setter;

//@Data 사용해서 Getter, Setter 한 번에 처리할 수도 있음
@Getter
@Setter
public class UserDTO {
	private String name, id, pwd;
}
