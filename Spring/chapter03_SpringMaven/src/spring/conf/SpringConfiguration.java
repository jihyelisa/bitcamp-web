package spring.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sample01.LoggingAdvice;
import sample01.MessageBeanImpl;

@Configuration
@EnableAspectJAutoProxy
public class SpringConfiguration {
	
	@Bean
	public MessageBeanImpl messageBeanImple() {
		return new MessageBeanImpl();
	}
	
	@Bean
	public LoggingAdvice logginAdvice() {
		return new LoggingAdvice();
	}
}
