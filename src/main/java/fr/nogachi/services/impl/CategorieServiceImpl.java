package fr.nogachi.services.impl;

import fr.nogachi.entities.Categorie;
import fr.nogachi.repositories.CategorieRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class CategorieServiceImpl implements CategorieService{

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

    @Override
    public List<Categorie> lister() {
        return null;
    }


    @Transactional
    public List<Categorie> categorie() {
        return categorieRepository.findAll();
    }

    @Transactional
    public Optional<Categorie> trouver(long id) {
        return categorieRepository.findById(id);
    }
}
