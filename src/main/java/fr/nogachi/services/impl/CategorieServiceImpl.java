package fr.nogachi.services.impl;

import fr.nogachi.entities.Categorie;
import fr.nogachi.repositories.CategorieRepository;
import fr.nogachi.services.CategorieService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Transactional
    public Categorie enregistrer(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    @Transactional
    public void supprimer(long id) {
        categorieRepository.deleteById(id);
    }

    @Transactional
    public List<Categorie> lister() {
        return categorieRepository.findAll();
    }

    @Transactional
    public Optional<Categorie> trouver(long id) {
        return categorieRepository.findById(id);
    }
}
