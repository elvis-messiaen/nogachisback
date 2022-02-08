package fr.nogachi;

import fr.nogachi.entities.Article;
import fr.nogachi.entities.Category;
import fr.nogachi.entities.Role;
import fr.nogachi.property.FileStorageProperty;
import fr.nogachi.repositories.ArticleRepository;
import fr.nogachi.repositories.CategoryRepository;
import fr.nogachi.repositories.RoleRepository;
import org.hibernate.type.LocalDateTimeType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperty.class
})
public class NogachiApplication {

    public static void main(String[] args) {
        SpringApplication.run(NogachiApplication.class, args);
    }

    @Bean
    CommandLineRunner start(RoleRepository roleRepository, ArticleRepository articleRepository, CategoryRepository categoryRepository) {
        return args -> {
            roleRepository.save(new Role(null,"ADMIN"));
            roleRepository.save(new Role(null,"USER"));
            Category Leg = new Category(null, "Legumes");
            Category Leg1= new Category(null, "Fruit");
            Category Leg2 = new Category(null, "Viande");
            Category Leg3 = new Category(null, "Volailes");
            Category Leg4 = new Category(null, "Conserve");
            categoryRepository.save(Leg);
            categoryRepository.save(Leg1);
            categoryRepository.save(Leg2);
            categoryRepository.save(Leg3);
            categoryRepository.save(Leg4);

            Article article1 = new Article(null,"carotte","berbberbrbebrbebrberbe", LocalDate.of(2021, 01, 01), "photo1");
            Article article2 = new Article(null,"navet","berbberbrbebrbebrberbe", LocalDate.of(1940, 01, 01), "photo2");
            Article article3 = new Article(null,"poulet","berbberbrbebrbebrberbe", LocalDate.of(2021, 01, 01), "photo3");
            Article article4 = new Article(null,"pomme de terre","berbberbrbebrbebrberbe", LocalDate.of(1980, 01, 01), "photo4");
            Article article5 = new Article(null,"épinard","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "photo5");

            articleRepository.save(article1);
            articleRepository.save(article2);
            articleRepository.save(article3);
            articleRepository.save(article4);
            articleRepository.save(article5);
        };
    }

}
