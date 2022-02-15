package fr.nogachi.entities;

import fr.nogachi.enumeration.ModeConservation;
import fr.nogachi.enumeration.TypesCard;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Article implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition="LONGTEXT")
    private String content;

    private LocalDate date;

    private String namephoto;

    @Enumerated(EnumType.STRING)
    private TypesCard nametype;

    @Enumerated(EnumType.STRING)
    private ModeConservation modeconservation;

    @ManyToOne(fetch = FetchType.LAZY)
    private  Category namecategory;

    public Article(Long id, String title, String content, LocalDate date, String namephoto, TypesCard nametype) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.namephoto = namephoto;
        this.nametype = nametype;
    }
    public Article(Long id, String title, String content, LocalDate date, String namephoto) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.namephoto = namephoto;
    }
}
