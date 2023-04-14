package spring.conf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:spring/db.properties")
@EnableTransactionManagement
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
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
		sqlSessionFactoryBean.setDataSource(dataSource());
		sqlSessionFactoryBean.setConfigLocation(new ClassPathResource("spring/mybatis-config.xml"));
		sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper.xml"));
		
		return sqlSessionFactoryBean.getObject();
	}

	@Bean
	public SqlSessionTemplate sqlSession() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		return sqlSessionTemplate;
	}
	
	@Bean
	public DataSourceTransactionManager transactionManager(){
		return new DataSourceTransactionManager(dataSource());
	}
}
/* @Bean
- 메소드의 return 값을 bean으로 생성
- 메소드의 이름은 반드시 bean의 id명과 같아야 한다.
*/

/* mapper 파일이 여러개일 경우 작성방법

1.
sqlSessionFactoryBean.setMapperLocations(new ClassPathResource("user/dao/userMapper1.xml"),
										 new ClassPathResource("user/dao/userMapper2.xml"),
										 new ClassPathResource("user/dao/userMapper3.xml"));

2. 필드 선언 */
// @Autowired
// private ApplicationContext context;
// sqlSessionFactoryBean.setMapperLocations(context.getResources("classpath:*/dao/*Mapper.xml"));
