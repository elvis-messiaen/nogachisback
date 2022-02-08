package fr.nogachi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

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

    @ManyToOne(fetch = FetchType.LAZY)
    private  Category namecategory;

    public Article(Long id, String title, String content, LocalDate date, String namephoto) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.date = date;
        this.namephoto = namephoto;
    }
}
