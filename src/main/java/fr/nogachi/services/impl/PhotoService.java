package fr.nogachi.services.impl;

import fr.nogachi.dtos.photo.PhotoDTO;
import fr.nogachi.dtos.photo.PhotoDeleteDTO;
import fr.nogachi.dtos.photo.PhotoUpdateDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

public interface PhotoService  {

    PhotoDTO save(MultipartFile namephoto);

    PhotoDTO update(PhotoUpdateDTO photoUpdateDTO);

    void delete(PhotoDeleteDTO photoDeleteDTO);

    List<PhotoDTO> findAll();

    Optional<PhotoDTO> findById(long id);
}
