package fr.nogachi;

import fr.nogachi.entities.Article;
import fr.nogachi.entities.Category;
import fr.nogachi.entities.Role;
import fr.nogachi.enumeration.TypesCard;
import fr.nogachi.property.FileStorageProperty;
import fr.nogachi.repositories.ArticleRepository;
import fr.nogachi.repositories.CategoryRepository;
import fr.nogachi.repositories.RoleRepository;
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
            Category leg = new Category(null, "Legumes");
            Category leg1= new Category(null, "Fruit");
            Category leg2 = new Category(null, "Viande");
            Category leg3 = new Category(null, "Volailes");
            Category leg4 = new Category(null, "Conserve");
            categoryRepository.save(leg);
            categoryRepository.save(leg1);
            categoryRepository.save(leg2);
            categoryRepository.save(leg3);
            categoryRepository.save(leg4);

            Article article1 = new Article(null,"carotte","berbberbrbebrbebrberbe", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);
            Article article2 = new Article(null,"navet","berbberbrbebrbebrberbe", LocalDate.of(1940, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);
            Article article3 = new Article(null,"poulet","berbberbrbebrbebrberbe", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);
            Article article4 = new Article(null,"pomme de terre","berbberbrbebrbebrberbe", LocalDate.of(1980, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);
            Article article5 = new Article(null,"épinard","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);

            Article recette1 = new Article(null,"poulet au épices","poulet au ", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);
            Article recette2 = new Article(null,"Salade de concombre au chèvre et olives","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);
            Article recette3 = new Article(null,"pate carbonara","blablablabkalalalalalalla", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.CONSERVATION);
            Article recette4 = new Article(null,"riz cantonai","riz mddsdmlfmdlfmdlmfdlfmsdlfsmdlmslmdlfmsdl", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.RECETTE);
            Article recette5 = new Article(null,"pate bolognaise","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.RECETTE);
            Article recette6 = new Article(null,"pizza au feu de bois","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.RECETTE);
            Article recette7 = new Article(null,"lasagne au chévre","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.RECETTE);
            Article recette8 = new Article(null,"poulet basquaise","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.RECETTE);
            Article recette9 = new Article(null,"apéro parti","jjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjj", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.RECETTE);
            Article recette10 = new Article(null,"Phô vietnamien","miam j'adore cela", LocalDate.of(2021, 01, 01), "http://localhost:8080/file/haricots-verts.jpg", TypesCard.RECETTE);

            articleRepository.save(article1);
            articleRepository.save(article2);
            articleRepository.save(article3);
            articleRepository.save(article4);
            articleRepository.save(article5);

            articleRepository.save(recette1);
            articleRepository.save(recette2);
            articleRepository.save(recette3);
            articleRepository.save(recette4);
            articleRepository.save(recette5);
            articleRepository.save(recette6);
            articleRepository.save(recette7);
            articleRepository.save(recette8);
            articleRepository.save(recette9);
            articleRepository.save(recette10);
        };
    }

}
