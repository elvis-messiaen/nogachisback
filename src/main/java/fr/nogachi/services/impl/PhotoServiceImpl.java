package fr.nogachi.services.impl;

import fr.nogachi.dtos.photo.PhotoDTO;
import fr.nogachi.dtos.photo.PhotoDeleteDTO;
import fr.nogachi.dtos.photo.PhotoSaveDTO;
import fr.nogachi.dtos.photo.PhotoUpdateDTO;
import fr.nogachi.entities.Photo;
import fr.nogachi.repositories.PhotoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    private final PhotoRepository photoRepository;
    private final ModelMapper modelMapper;
    private FileService fileService;

    public PhotoServiceImpl(PhotoRepository photoRepository, ModelMapper modelMapper, FileService fileService) {
        this.photoRepository = photoRepository;
        this.modelMapper = modelMapper;
        this.fileService = fileService;
    }



    public PhotoDTO save(MultipartFile namephoto) {
        PhotoSaveDTO photoSaveDTO = modelMapper.map(namephoto,PhotoSaveDTO.class);
        photoSaveDTO.setNamephoto(namephoto);

        String photoPath = fileService.uploadFile(photoSaveDTO.getNamephoto());
        Photo photo = modelMapper.map(photoSaveDTO, Photo.class);
        photo.setNamephoto(photoPath);

        Photo photosaved =this.photoRepository.save(photo);
        if (photosaved.getId() == null) {

        }
        return modelMapper.map(photosaved, PhotoDTO.class);
    }


    public PhotoDTO update(PhotoUpdateDTO photoUpdateDTO) {
        Photo photo = modelMapper.map(photoUpdateDTO, Photo.class);
        Photo photoDTO = this.photoRepository.save(photo);
        return modelMapper.map(photoDTO, PhotoDTO.class);
    }


    public void delete(PhotoDeleteDTO photoDeleteDTO) {
        Photo photo = modelMapper.map(photoDeleteDTO, Photo.class);
        photoRepository.delete(photo);
    }


    public List<PhotoDTO> findAll() {
        List<PhotoDTO> photoDTOList = new ArrayList<>();
        this.photoRepository.findAll().forEach(photo -> photoDTOList.add(modelMapper.map(photo, PhotoDTO.class)));
        return photoDTOList;
    }


    public Optional<PhotoDTO> findById(long id) throws NoSuchElementException {
        Optional<Photo> photo = this.photoRepository.findById(id);
        return Optional.of(modelMapper.map(photo.orElse(null), PhotoDTO.class));
    }

}
