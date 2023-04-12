package spring.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sample01.MessageBeanImpl;
import sample02.CalcAdd;
import sample02.CalcMul;
import sample04.SungJukDTO2;

@Configuration
public class SpringConfiguration {
	//applicationContext.xml과 같은 환경설정 역할을 할 수 있는 (bean을 생성할 수 있는) java 파일

	//sample01
	@Bean
	public MessageBeanImpl messageBeanImpl() {
		return new MessageBeanImpl("사과");
	}
	
	//sample02
	@Bean(name="calcAdd")
	public CalcAdd getCalcAdd() {
		return new CalcAdd(25, 36);
	}
	@Bean(name="calcMul")
	public CalcMul getCalcMul() {
		return new CalcMul();
	}
//	@Bean
//	public CalcMul calcMul() {
//		return new CalcMul();
//	}
	
	//sample04
	@Bean
	public List<SungJukDTO2> arrayList() {
		return new ArrayList<SungJukDTO2>();
	}
}
/*
@Bean
- 메소드의 return 값을 bean으로 생성
- 메소드의 이름은 반드시 bean의 id명과 같아야 한다.
*/