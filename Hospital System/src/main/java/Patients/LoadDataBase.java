package Patients;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(PatientsRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Patient("name1", "female", 547, 345, "pwd")));
            log.info("Preloading " + repository.save(new Patient("name2", "male", 647, 325, "pwd")));
        };
    }
}
