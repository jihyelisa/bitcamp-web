package sample04;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@Scope("prototype")
@Getter
@Setter
public class SungJukDTO2 {
	private String name;
	private int kor, eng, math, tot;
	private double avg;
}
