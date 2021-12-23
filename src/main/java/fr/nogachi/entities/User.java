package fr.nogachi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 20)
    @Column(nullable = false)
    private String email;

    @Size(min = 8, max = 40)
    @Column(name = "passWord", nullable = false, length = 40)
    private String passWord;

    @OneToOne
    private Role role;
}
