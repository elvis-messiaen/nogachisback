package fr.nogachi.services.impl;

import fr.nogachi.Exception.FileStorageException;
import fr.nogachi.property.FileStorageProperty;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    private final Path filerStorageLocation;


    public FileService(FileStorageProperty filerStorageLocation) {
        this.filerStorageLocation = Paths.get(filerStorageLocation.getUploadDir())
                .normalize();

        // Création du dossier si il existe pas

        try {
            Files.createDirectories(this.filerStorageLocation);
        }catch (Exception e) {
            throw  new FileStorageException("impossible de créer le dossier");
        }
    }

    public String uploadFile (MultipartFile multipartFile) {
        String filename = StringUtils.cleanPath(multipartFile.getOriginalFilename());
         try  {
             if (filename.contains("..")) {
                 throw  new FileStorageException("nom de fichier incorrect");
             }
             filename = filename.replaceAll(" ","_");
             filename = filename;// + LocalDateTime.now();
             Path cheminDeDestination = filerStorageLocation.resolve(filename);
             Files.copy(multipartFile.getInputStream(),cheminDeDestination, StandardCopyOption.REPLACE_EXISTING);
             return ServletUriComponentsBuilder.fromCurrentContextPath()// renvoie une String
                     .path("photo/storage/")
                     .path(filename)
                     .toUriString();
         } catch (IOException e) {
             throw new FileStorageException("Erreur lors du téléchargement du fichier");
         }
    }

    public Resource downloadFile(String filename) throws FileNotFoundException {
        try {
            Path path  = this.filerStorageLocation.resolve(filename).normalize();
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists()) {
                return resource;
            }else {
                throw new FileNotFoundException("fichier introuvable");
            }
        } catch (MalformedURLException e) {
            throw new FileNotFoundException("Path du fichier mal formatté");
        }
    }
}
