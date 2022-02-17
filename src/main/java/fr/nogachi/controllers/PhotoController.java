package fr.nogachi.controllers;

import fr.nogachi.dtos.photo.PhotoDTO;
import fr.nogachi.dtos.photo.PhotoDeleteDTO;
import fr.nogachi.dtos.photo.PhotoUpdateDTO;
import fr.nogachi.services.PhotoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/photo")
public class PhotoController {

    private PhotoService photoService;

    @Autowired
    private ModelMapper mapper;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    /**
     * Affiche la liste des photos
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @GetMapping()
    public List<PhotoDTO> listPhoto() {
        return photoService.findAll();
    }

    /**
     * Recherche une photo par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     *
     * @return
     */
    @GetMapping("/{id}")
    public Optional<PhotoDTO> findPhotoById(@PathVariable Long id) {
        return photoService.findById(id);
    }

    /**
     * Ajoute une photo
     * POSTMAN : Ok
     * TEST UNITAIRE : WIP
     */
    @PostMapping()
    public PhotoDTO createPhoto(@RequestParam MultipartFile namephoto) {
        return this.photoService.save(
                namephoto
        );
    }

    /**
     * Met à jour une photo par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @PutMapping("/{id}")
    public PhotoDTO updatePhoto(@PathVariable Long id, @RequestBody PhotoUpdateDTO photoUpdateDTO) {
        photoUpdateDTO.setId(id);
        return photoService.update(photoUpdateDTO);
    }

    /**
     * Supprime une photo par id
     * POSTMAN : OK
     * TEST UNITAIRE : WIP
     */
    @DeleteMapping()
    public void deletePhoto(@RequestBody PhotoDeleteDTO photoDeleteDTO) {
        photoService.delete(photoDeleteDTO);
    }
}
