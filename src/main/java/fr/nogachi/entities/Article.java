package fr.nogachi.entities;

import fr.nogachi.enumeration.ModeConservation;
import fr.nogachi.enumeration.TypesCard;
import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false, columnDefinition="LONGTEXT")
    private String contentdescription;

    private LocalDate date;

    private String namephoto;

    @Enumerated(EnumType.STRING)
    private TypesCard nametype;

    @Enumerated(EnumType.STRING)
    private ModeConservation modeconservation;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Category namecategory;

    public Article(Long id, String title, String content, LocalDate date, String namephoto, TypesCard nametype,String contentdescription) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.namephoto = namephoto;
        this.nametype = nametype;
        this.contentdescription = contentdescription;
    }
    public Article(Long id, String title, String content, LocalDate date, String namephoto) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.namephoto = namephoto;
    }
}
