package demo.hello.plaync.webapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class HelloPlayncWebApplication {

	public static void main(String[] args) throws Exception {
		new SpringApplicationBuilder(HelloPlayncWebApplication.class)
			.properties("spring.config.name=application,database-connection")
			.run(args);
	}

}