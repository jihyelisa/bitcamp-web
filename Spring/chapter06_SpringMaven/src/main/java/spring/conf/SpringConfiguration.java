package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import user.bean.UserDTO;
import user.dao.UserDAOImpl;
import user.main.HelloSpring;

@Configuration
@PropertySource("classpath:spring/db.properties")
public class SpringConfiguration {
	private @Value("${jdbc.driver}") String driver;
	private @Value("${jdbc.url}") String url;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;
	
	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUrl(url);
		basicDataSource.setUsername(username);
		basicDataSource.setPassword(password);
		return basicDataSource;
	}
	
	@Bean
	public HelloSpring helloSpring() {
		return new HelloSpring();
	}
	
	@Bean(name="userDTO")
	@Scope("prototype")
	public UserDTO userDTO() {
		return new UserDTO();
	}
	@Bean(name="userDAOImpl")
	public UserDAOImpl userDAOImpl() {
		return new UserDAOImpl();
	}
}
/*
@Bean
- 메소드의 return 값을 bean으로 생성
- 메소드의 이름은 반드시 bean의 id명과 같아야 한다.
*/