package app;

import dao.UserDaoService;
import dao.impl.UserDaoServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import service.UserService;
import service.impl.UserServiceImpl;

@SpringBootApplication
public class DummyBoot {

	public static void main(String[] args) {
		SpringApplication.run(DummyBoot.class, args);
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	@Bean
	public UserDaoService userDaoService() {
		return new UserDaoServiceImpl();
	}
}
