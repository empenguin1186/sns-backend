package jp.co.training.sns;

import jp.co.training.sns.Mapper.UserMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class SnsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SnsApplication.class, args);
	}
	
//	private final UserMapper userMapper;
//
//	public SnsApplication(UserMapper userMapper) {
//		this.userMapper = userMapper; // Mapperをインジェクションする
//	}
//
//	@Bean
//	CommandLineRunner sampleCommandLineRunner() {
//		return (args) -> System.out.println(this.userMapper.findOne("kodaira"));
//	}

}

