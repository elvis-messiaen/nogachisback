package fr.nogachi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String email;

    @Size(min = 8, max = 40)
    @Column(name = "password", nullable = false, length = 40)
    private String password;

    @OneToOne
    private Role role;

    @ManyToMany
    @JoinTable(
            name ="article_has_user",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name="user_id")
    )
    private List<Article> articleList;
}
