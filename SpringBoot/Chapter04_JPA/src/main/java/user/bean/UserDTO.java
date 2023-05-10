package user.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "usertable")
@Data
public class UserDTO {
	
	@Column(nullable=false, length=30)
	private String name;
	
	@Id //primary key
	@Column(nullable=false, length=30)
	private String id;
	
	@Column(nullable=false, length=30)
	private String pwd;
}
