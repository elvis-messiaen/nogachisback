package fr.nogachi.controllers;

import fr.nogachi.entities.Photo;
import fr.nogachi.repositories.PhotoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PhotoController {

    private final PhotoRepository photoRepository;

    /**
     * Instancie à la demande le repository photo
     */
    public PhotoController(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    /**
     * Affiche la liste des photos
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/photo")
    public List<Photo> listPhoto() {
        return photoRepository.findAll();
    }

    /**
     * Recherche une photo par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping(path = "/photo/{id}")
    public Photo findPhotoById(@PathVariable Long id) {

        return photoRepository.findById(id).get();
    }

    /**
     * Ajoute une photo
     * POSTMAN : Ok
     * TEST UNITAIRE : WIP
     */
    @PostMapping(path = "/photo")
    public Photo createPhoto(@RequestBody Photo photo) {
        return photoRepository.save(photo);
    }

    /**
     * Met à jour une photo par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping(path = "/photo/{id}")
    public Photo updatePhoto(@PathVariable Long id, @RequestBody Photo photo) {
        photo.setId(id);
        return photoRepository.save(photo);
    }

    /**
     * Supprime une photo par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping(path = "/photo/{id}")
    public void deletePhoto(@PathVariable Long id) {
        photoRepository.deleteById(id);
    }
}
