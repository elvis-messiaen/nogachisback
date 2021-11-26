package fr.nogachi.entity;

import javax.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(name = "motDePasse", nullable = false, length = 20)
    private String mdp;

    @OneToOne
    private Role role;
}
