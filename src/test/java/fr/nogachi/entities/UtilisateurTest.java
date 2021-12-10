package fr.nogachi.entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilisateurTest {

    @Test
    void getEmail() {
        Role role = new Role(null,"administrateur");
        Utilisateur utilisateur = new Utilisateur(null,"elvis@hotmail.com","222222",role);
        assertEquals("elvis@hotmail.com",utilisateur.getEmail());
    }
    @Test
    void verifTailleEmail() {
        Role role = new Role(null,"administrateur");
        Utilisateur utilisateur = new Utilisateur(null,"elvis@hotmail.com","222222",role);
        if (utilisateur.getEmail().length() < 3 || utilisateur.getEmail().length() >20 ){

        }
        assertEquals("elvis@hotmail.com",utilisateur.getEmail().length());
    }

    @Test
    void getMdp() {
    }

    @Test
    void setEmail() {
    }

    @Test
    void setMdp() {
    }
}