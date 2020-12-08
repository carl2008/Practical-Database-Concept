package com.rmit.Practical_Database_Concept;

/**
 * import com.rmit.Practical_Database_Concept.user.repository.UserRepository;
 * import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/**
 * EnableJpaRepositories(basePackageClasses = UserRepository.class)
 */
public class PracticalDatabaseConceptApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticalDatabaseConceptApplication.class, args);
	}

}
