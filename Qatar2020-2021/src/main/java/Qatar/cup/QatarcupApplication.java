package Qatar.cup;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EnableJpaRepositories(basePackages="Qatar.cup")

public class QatarcupApplication {

	public static void main(String[] args) {
		SpringApplication.run(QatarcupApplication.class, args);
	}

}
