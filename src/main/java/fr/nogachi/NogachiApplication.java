package fr.nogachi;

import fr.nogachi.entities.Role;
import fr.nogachi.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class NogachiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NogachiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(RoleRepository roleRepository) {
        return args -> {
            roleRepository.save(new Role(null,"ADMINISTRATEUR"));
            roleRepository.save(new Role(null,"USER"));
        };
    }

}
