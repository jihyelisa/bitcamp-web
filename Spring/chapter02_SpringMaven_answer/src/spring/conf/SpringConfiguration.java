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
	
	//sample01
	@Bean
	public MessageBeanImpl messageBeanImpl(){
		return new MessageBeanImpl("사과");
	}
	
	//sample02
	@Bean
	public CalcAdd calcAdd(){
		return new CalcAdd(22, 55);
	}
	
//	@Bean
//	public CalcMul calcMul(){
//		return new CalcMul();
//	}
	
	@Bean(name="calcMul")
	public CalcMul getCalcMul(){
		return new CalcMul();
	}
	
	//sample04
	@Bean
	//public ArrayList<SungJukDTO2> arrayList(){
	public List<SungJukDTO2> arrayList(){
		return new ArrayList<SungJukDTO2>();
	}

}

/*
@Bean
- 메소드에서 return 되는 값을 빈으로 생성해준다.
- 메소드의 이름은 반드시 빈의 id명으로 만들어야 한다.
*/













